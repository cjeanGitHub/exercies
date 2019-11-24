package com.cjean.spring.three;

import com.cjean.spring.two.zkconfig.zkUtil.ZkConnec;
import org.apache.zookeeper.ZooKeeper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author 14172
 * @create 2019/11/23
 * @since 1.0.0
 */
public class TestLock {

    ZooKeeper zk;


    @Before
    public void getZookeeper() {
        zk = ZKUtils.getZK();
    }
    @After
    public void closeZk() {
        try {
            zk.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLock() {

        // 模拟多线程 抢锁 执行

        for (int i = 0; i <10 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // 每一个线程 都需要创建一个自己的watch 监听事件
                    MyWatchLock myWatchLock = new MyWatchLock();;
                    myWatchLock.setZk(zk);
                    String threadName = Thread.currentThread().getName();
                    myWatchLock.setThreadName(threadName);

                    //抢锁
                    myWatchLock.tryLock();
                    System.out.println("干活....");
                    // 由于太快了 会造成死锁
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

                    //释放锁
                    myWatchLock.unLock();
                }
            }).start();

        }

        while (true){

        }

    }
}



