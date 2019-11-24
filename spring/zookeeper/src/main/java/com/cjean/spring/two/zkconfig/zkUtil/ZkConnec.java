/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ZkConnec
 * Author:   14172
 * Date:     2019/11/23 13:01
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cjean.spring.two.zkconfig.zkUtil;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author 14172
 * @create 2019/11/23
 * @since 1.0.0
 */

// 对zk连接的配置
public class ZkConnec {

//    private static String connectedAddr = "192.168.101.142:2181,192.168.101.143:2181,192.168.101.144:2181,192.168.101.145:2181/testConf";
    private static String connectedAddr = "192.168.101.142:2181,192.168.101.143:2181,192.168.101.144:2181,192.168.101.145:2181/testLock";
    private static int sessionTimeout = 300000;
    private static ZooKeeper zk;
    private static final Stat stat = new Stat();
    private static CountDownLatch cc = new CountDownLatch(1);
    private static MyWatcher myWatcher = new MyWatcher(cc);

    public static ZooKeeper getZookeeper() {
        if (null == zk) {
            try {
                zk = new ZooKeeper(connectedAddr, sessionTimeout, myWatcher);
                cc.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return zk;
    }

    public static void main(String[] args) throws Exception {
        ZooKeeper zookeeper = ZkConnec.getZookeeper();

        byte[] data = zookeeper.getData("/xxoo", false, null);
        System.out.println("返回数据：" + new String(data));
    }


}
