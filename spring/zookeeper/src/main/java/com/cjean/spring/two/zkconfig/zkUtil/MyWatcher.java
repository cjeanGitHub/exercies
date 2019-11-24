/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MyWatcher
 * Author:   14172
 * Date:     2019/11/23 13:24
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cjean.spring.two.zkconfig.zkUtil;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

/**
 * @author 14172
 * @create 2019/11/23
 * @since 1.0.0
 */
public class MyWatcher extends MyWatcherSuper {

    private static CountDownLatch cc = null;
    private static ZooKeeper zk;
    private Stat stat = new Stat();
    private static MyConf myConf;

    public MyWatcher() {
    }

    public MyWatcher(CountDownLatch cc) {
        this.cc = cc;
    }

    public MyWatcher(CountDownLatch cc, ZooKeeper zk) {
        this.cc = cc;
        this.zk = zk;
    }

    public MyWatcher(CountDownLatch cc, ZooKeeper zk, MyConf myConf) {
        this.cc = cc;
        this.zk = zk;
        this.myConf = myConf;

    }

    public void aWait() {
        zk.exists("/xxoo2", this, this, "asd");
        try {
            cc.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 异步数据的回调
    @Override
    public void processResult(int rc, String path, Object ctx, byte[] data, Stat stat) {
        System.out.println("异步数据的回调===rc:" + rc);
        System.out.println("异步数据的回调===path:" + path);
        System.out.println("异步数据的回调===ctx:" + ctx);
//        System.out.println("异步数据的回调===data:" + new String(data));// data 是空的时候 会报错
        System.out.println("异步数据的回调===stat:" + stat);

        if (null != data) {
            myConf.setInfo(new String(data));
            cc.countDown();
        } else {
            myConf.setInfo("异步数据的回调 *节点被删除，没有数据*");
            cc.countDown();
        }
    }

    // 异步 状态 回调
    @Override
    public void processResult(int rc, String path, Object ctx, Stat stat) {
        System.out.println("异步 状态 回调===rc:" + rc);
        System.out.println("异步 状态 回调===path:" + path);
        System.out.println("异步 状态 回调===ctx:" + ctx);
//        System.out.println("异步 状态 回调===stat:" + stat.toString());// 状态为空会报错

        if (null != stat) {
            System.out.println("异步 状态 回调 的stat 不为空，节点存在");
            // 获取 该节点的 数据byte[] datas = (byte[])
            try {
                zk.getData(path, this, this, "异步 状态 回调");// 第二个this 参数 是本类中的数据异步回调方法
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("异步 状态 回调 的stat 为空，去调用 异步数据回调方法");
            zk.getData(path, this, this, "异步 状态 回调");
        }
    }

    // 监视器 的回调
    @Override
    public void process(WatchedEvent event) {
        System.out.println("监视器 的回调===event.getType:" + event.getType());
        System.out.println("监视器 的回调===event.getState:" + event.getState());
        System.out.println("监视器 的回调===event.getPath:" + event.getPath());

        Event.KeeperState state = event.getState();
        switch (state) {
            case Unknown:
                System.out.println("event.state:Unknown");
                break;
            case Disconnected:
                System.out.println("event.state:Disconnected");
                break;
            case NoSyncConnected:
                System.out.println("event.state:NoSyncConnected");
                break;
            case SyncConnected:
                System.out.println("event.state:SyncConnected");
                //同步连接成功
                cc.countDown();
                break;
            case AuthFailed:
                System.out.println("event.state:AuthFailed");
                break;
            case ConnectedReadOnly:
                System.out.println("event.state:ConnectedReadOnly");
                break;
            case SaslAuthenticated:
                System.out.println("event.state:SaslAuthenticated");
                break;
            case Expired:
                System.out.println("event.state:Expired");
                break;
        }

        Event.EventType type = event.getType();
        switch (type) {
            case None:
                System.out.println("event.getType:None");
                aWait();
                break;
            case NodeCreated:
                System.out.println("event.getType:NodeCreated");
                aWait();
                break;
            case NodeDeleted:
                System.out.println("event.getType:NodeDeleted");
                aWait();
                break;
            case NodeDataChanged:
                System.out.println("event.getType:NodeDataChanged");
                aWait();
                break;
            case NodeChildrenChanged:
                System.out.println("event.getType:NodeChildrenChanged");
                break;
        }
    }


}
