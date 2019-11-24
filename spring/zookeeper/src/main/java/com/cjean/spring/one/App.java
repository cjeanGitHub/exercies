package com.cjean.spring.one;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.rmi.server.ExportException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * Hello world!
 */
public class App {

    //zk是有session概念的，没有连接池的概念
    //watch:观察，回调
    //watch的注册值发生在 读类型调用，get，exites。。。
    //第一类：new zk 时候，传入的watch，这个watch，session级别的，跟path 、node没有关系。
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");
        String zkAddrPort = "192.168.101.142:2181,192.168.101.143:2181,192.168.101.144:2181,192.168.101.145:2181";

        //由于
        final CountDownLatch countDownLatch = new CountDownLatch(1);//程序计数器
        new Semaphore(1);


        final ZooKeeper zooKeeper = new ZooKeeper(zkAddrPort,
                300000, new Watcher() {
            //Watch 的回调方法！ 由于process方法是异步进行的 所以增加线程控制来实现 线程同步进行  程序计数器 信号量 回环栅栏
            @Override
            public void process(WatchedEvent event) {
                System.out.println("new zk watch:ZooKeeper----Watcher");
                System.out.println("WatchedEvent event:" + event.toString());
                System.out.println("ZooKeeper----Watcher----more");
                String path = event.getPath();
                System.out.println("path:" + path);
                Event.KeeperState state = event.getState();
                System.out.println("event.getState():" + state);

                switch (state) {
                    case Unknown:
                        System.out.println("event.getState():Unknown");
                        break;
                    case Disconnected:
                        System.out.println("event.getState():Disconnected");
                        break;
                    case NoSyncConnected:
                        System.out.println("event.getState():NoSyncConnected");
                        break;
                    case SyncConnected:
                        System.out.println("event.getState():SyncConnected");
                        //释放 锁
                        countDownLatch.countDown();
                        break;
                    case AuthFailed:
                        System.out.println("event.getState():AuthFailed");
                        break;
                    case ConnectedReadOnly:
                        System.out.println("event.getState():ConnectedReadOnly");
                        break;
                    case SaslAuthenticated:
                        System.out.println("event.getState():SaslAuthenticated");
                        break;
                    case Expired:
                        System.out.println("event.getState():Expired");
                        break;
                }

                Event.EventType type = event.getType();
                System.out.println("event.getType():" + type);
                switch (type) {
                    case None:
                        System.out.println("event.getType();None");
                        break;
                    case NodeCreated:
                        System.out.println("event.getType();NodeCreated");
                        break;
                    case NodeDeleted:
                        System.out.println("event.getType();NodeDeleted");
                        break;
                    case NodeDataChanged:
                        System.out.println("event.getType();NodeDataChanged");
                        break;
                    case NodeChildrenChanged:
                        System.out.println("event.getType();NodeChildrenChanged");
                        break;
                }
            }
        });
        //持有锁 等process 回调方法执行完毕
        countDownLatch.await();
        ZooKeeper.States state = zooKeeper.getState();
        switch (state) {
            case CONNECTING:
                System.out.println("zooKeeper.getState():CONNECTING");
                break;
            case ASSOCIATING:
                System.out.println("zooKeeper.getState():ASSOCIATING");
                break;
            case CONNECTED:
                System.out.println("zooKeeper.getState():CONNECTED");
                break;
            case CONNECTEDREADONLY:
                System.out.println("zooKeeper.getState():CONNECTEDREADONLY");
                break;
            case CLOSED:
                System.out.println("zooKeeper.getState():CLOSED");
                break;
            case AUTH_FAILED:
                System.out.println("zooKeeper.getState():AUTH_FAILED");
                break;
            case NOT_CONNECTED:
                System.out.println("zooKeeper.getState():NOT_CONNECTED");
                break;
        }

        //创建一个节点
        zooKeeper.create("/java","this is come form java！！".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        //获取这个节点并且对这个节点增加watcher
        final Stat stat = new Stat();

        byte[] data = zooKeeper.getData("/java", new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("zooKeeper.getData-event-java：" + event.toString());
                try {
                    byte[] data1 = zooKeeper.getData("/java", this, stat);
                    System.out.println("event造成监视事件，现在数据为："+new String(data1));
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, stat);
        System.out.println("get Date："+new String(data));

        // 出发 get 时 对 java这个节点的监视事件
        System.out.println("开始触发sett了");
        Stat stat1 = zooKeeper.setData("/java", "java changge".getBytes(), 0);
        System.out.println("结束sett了");

        System.out.println("开始再次触发sett了");
        Stat stat2 = zooKeeper.setData("/java","java changge22222".getBytes(),stat1.getVersion());
        System.out.println("再次结束sett了");

        //异步回调
        zooKeeper.getData("/java", false, new AsyncCallback.DataCallback() {
            @Override
            public void processResult(int rc, String path, Object ctx, byte[] data, Stat stat) {
                System.out.println(" new AsyncCallback.DataCallback()");
                System.out.println("rc:"+rc);
                System.out.println("path:"+path);
                System.out.println("data:"+new String(data));
                System.out.println("stat:"+stat);
                System.out.println("ctx:"+ctx);
            }
        },stat);


        Thread.sleep(10000);
        System.out.println("结束");

    }
}
