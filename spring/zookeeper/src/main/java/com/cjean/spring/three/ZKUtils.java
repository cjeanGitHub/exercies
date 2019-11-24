package com.cjean.spring.three;

import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author: 马士兵教育
 * @create: 2019-09-20 20:08
 */
public class ZKUtils {

    private  static ZooKeeper zk;

    private static String address = "192.168.101.142:2181,192.168.101.143:2181,192.168.101.144:2181,192.168.101.145:2181/testLock";

    private static DefaultWatch watch = new DefaultWatch();

    private static CountDownLatch init  =  new CountDownLatch(1);
    public static ZooKeeper  getZK(){

        try {
            zk = new ZooKeeper(address,20000,watch);
            watch.setCc(init);
            init.await();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return zk;
    }


}