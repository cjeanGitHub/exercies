/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MyWatchLock
 * Author:   14172
 * Date:     2019/11/24 22:39
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cjean.spring.three;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author 14172
 * @create 2019/11/24
 * @since 1.0.0
 */
public class MyWatchLock implements Watcher, AsyncCallback.StringCallback, AsyncCallback.Children2Callback, AsyncCallback.StatCallback {

    ZooKeeper zk;
    CountDownLatch cc = new CountDownLatch(1);
    String threadName;
    String pathName;


    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public ZooKeeper getZk() {
        return zk;
    }

    public void setZk(ZooKeeper zk) {
        this.zk = zk;
    }

    public void tryLock(){
        // 创建一个临时排序节点
        System.out.println(threadName+"：创建一个临时排序节点");
        zk.create("/lock",threadName.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL,this,"create");
        try {
            System.out.println(threadName+"：排队中...");
            cc.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void unLock(){
        try {
            // 删除临时排序节点 释放当前线程 锁
            System.out.println(pathName+"：节点删除，释放锁...");
            zk.delete(pathName,-1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void process(WatchedEvent event) {
        switch (event.getType()) {
            case None:
                break;
            case NodeCreated:
                break;
            case NodeDeleted:
                // 如果删除了 就只执行 获取根目录下 所有存在的子节点 重新排序监听
//                System.out.println(pathName+"：节点删除，释放锁.NodeDeleted..");
                zk.getChildren("/",false,this,"NodeDeleted");
                break;
            case NodeDataChanged:
                break;
            case NodeChildrenChanged:
                break;
        }
    }

    // StringCall back
    @Override
    public void processResult(int rc, String path, Object ctx, String name) {
        if (null != name){//创建成功节点
            pathName = name;
            System.out.println(pathName+"：节点创建成功.StringCallback..");
            zk.getChildren("/",false,this,"get Childer");
        }
    }

    // childer call back
    @Override
    public void processResult(int rc, String path, Object ctx, List<String> children, Stat stat) {
        if (children.size()>0){// if childer is not null
            // iter childer
            Collections.sort(children);
            int i = children.indexOf(pathName.substring(1));

            if (0 == i){// 如果 这个节点是第一个就释放锁
                System.out.println(pathName+"：节点是第一个干活的.childer call back..");
                try {
                    // 由于太快了 会造成死锁 前面的 Thread.sleep(2000); 就 是为了别让他太快
                    zk.setData("/",threadName.getBytes(),-1);
                    cc.countDown();
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }else {// 如果不是第一个就检查前一个还在不在
                zk.exists("/"+children.get(i-1),this,this,"exists");
            }

        }
    }

    @Override
    public void processResult(int rc, String path, Object ctx, Stat stat) {
        // 暂不处理
    }
}
