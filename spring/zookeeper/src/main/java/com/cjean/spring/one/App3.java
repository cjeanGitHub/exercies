package com.cjean.spring.one;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * Hello world!
 */
public class App3 {

    //zk是有session概念的，没有连接池的概念
    //watch:观察，回调
    //watch的注册值发生在 读类型调用，get，exites。。。
    //第一类：new zk 时候，传入的watch，这个watch，session级别的，跟path 、node没有关系。
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");
        String zkAddrPort = "192.168.101.142:2181,192.168.101.143:2181,192.168.101.144:2181,192.168.101.145:2181";

        // 为同步 zk 连接 设置 程序计数器 打到 同步单个线程
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        final ZooKeeper zooKeeper = new ZooKeeper(zkAddrPort, 30000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("new ZooKeeper:event");
                System.out.println("");

                // 获取 时间发生目录 路径
                String path = event.getPath();
                System.out.println("event.path:"+path);

                //获取事件 状态
                Event.KeeperState state = event.getState();
                System.out.println("event.state:"+state);
                switch (state) {
                    case Unknown:
                        break;//未知状态
                    case Disconnected:
                        break;//未连接状态
                    case NoSyncConnected:
                        break;//同步连接
                    case SyncConnected:
                        // 连接成功 释放锁
                        countDownLatch.countDown();
                        break;//异步连接
                    case AuthFailed:
                        break;//授权是啊比
                    case ConnectedReadOnly:
                        break;//只读连接
                    case SaslAuthenticated:
                        break;//
                    case Expired:
                        break;//设置 存活时间
                }

                // 获取监听事件 类型
                Event.EventType type = event.getType();
                System.out.println("event.type:"+type);
                switch (type) {
                    case None:
                        break;// 未监听道事件
                    case NodeCreated:
                        break;//监听到节点创建
                    case NodeDeleted:
                        break;//监听到节点删除
                    case NodeDataChanged:
                        break;//监听到节点更改
                    case NodeChildrenChanged:
                        break;//监听到子节点更改
                }
            }
        });

        //由于 zk 默认是内部异步连接的 所以在下面 等待zk 真正连接完毕再执行以下代码
        countDownLatch.await();

        // 获取 zk 的 连接状态
        ZooKeeper.States state = zooKeeper.getState();
        System.out.println("zooKeeper.getState:"+state);
        switch (state) {// 连接中
            case CONNECTING:
                break;
            case ASSOCIATING:
                break;//授权中
            case CONNECTED:
                System.out.println("：：：：连接成功：：：：");
                break;//已连接
            case CONNECTEDREADONLY:
                break;//只读连接
            case CLOSED:
                break;//关闭
            case AUTH_FAILED:
                break;//授权失败
            case NOT_CONNECTED:
                break;//未连接
        }

        // 连接成功 开始 设置节点数据
        final Stat stat = new Stat();
        final String s = zooKeeper.create("/java", "come form java one".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println("开始 设置节点 ，响应数据："+s);
        // 获取数据
        byte[] data = zooKeeper.getData("/java", new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                try {
                    System.err.println("获取数据 回调");
                    System.err.println("获取事件的发生路径:"+event.getPath());
                    System.err.println("获取事件的类型:"+event.getType());
                    System.err.println("获取事件的状态:"+event.getState());
                    //TODO 如果执行下面这个获取事件 或导致 第一次触发 setDate 回调 不能返回 data1 的情况 待处理//
//                    System.err.println("获取事件的*****getWrapper:"+event.getWrapper());

                    byte[] data1 = zooKeeper.getData("/java", this, stat);
                    System.out.println("getData>Watcher>process>zooKeeper.getData:"+new String(data1));
                    System.err.println("获取数据 回调完毕");
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                countDownLatch.countDown();
            }
        }, stat);
        System.err.println("返回数据是："+new String(data));

        // 重新设置 节点的数据  第一次
        Stat stat1 = zooKeeper.setData("/java", "重新设置 节点的数据  第一次".getBytes(), 0);
//        countDownLatch.await();
        System.err.println("stat1:"+stat1.toString());
//        Thread.sleep(13000);
        // 重新设置 节点的数据  第2次
        Stat stat2 = zooKeeper.setData("/java", "重新设置 节点的数据  第2次".getBytes(), stat1.getVersion());
//        countDownLatch.await();
        System.err.println("stat2:"+stat2.toString());

        // Zookeeper—curd操作和watcher、AsyncCallback使用 https://www.jianshu.com/p/92673ab80b29
        zooKeeper.getData("/java", false, new AsyncCallback.DataCallback() {
            @Override
            public void processResult(int rc, String path, Object ctx, byte[] data, Stat stat) {
                System.out.println("AsyncCallback ing、、、");
                System.out.println("rc:"+rc);
                System.out.println("path:"+path);
                System.out.println("ctx:"+ctx);
                System.out.println("data:"+new String(data));
                System.out.println("stat:"+stat.toString());
                System.out.println("AsyncCallback ed、、、");
            }
        },stat);

        Thread.sleep(13000);
        System.out.println("结束.....");


    }
}
