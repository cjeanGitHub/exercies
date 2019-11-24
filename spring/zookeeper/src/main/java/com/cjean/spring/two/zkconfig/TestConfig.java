/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TestConfig
 * Author:   14172
 * Date:     2019/11/23 13:00
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cjean.spring.two.zkconfig;

import com.cjean.spring.two.zkconfig.zkUtil.MyConf;
import com.cjean.spring.two.zkconfig.zkUtil.MyWatcher;
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
public class TestConfig {

    ZooKeeper zk;
    MyWatcher myWatcher;
    MyConf myConf ;

    @Before
    public void getZookeeper() {
        zk = ZkConnec.getZookeeper();
        myConf= new MyConf();
        CountDownLatch cc = new CountDownLatch(1);
        myWatcher = new MyWatcher(cc,zk,myConf);
//        zk.create();
//        public void create(final String path, byte data[], List<ACL> acl,
//                CreateMode createMode,  StringCallback cb, Object ctx){ }// 如果创建成功 回调 StringCallBack 方法

//        zk.getChildren();

        /**
         * public void getChildren(String path, boolean watch, Children2Callback cb,
         *             Object ctx)
         *     {
         *         getChildren(path, watch ? watchManager.defaultWatcher : null, cb, ctx);
         *     }
         *
         * 触发 Children2Callback 回调方法
         */



    }


    @After
    public void closeZk() {
        try {
            zk.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 功能描述: <br>
     * 1.查看这个节点存不存在
     * 1.1存在
     * 获取这个节点的数据
     * 1.2不存在
     * 新增这个节点，并且返回这个节点的数据
     * 2.对节点进行删除
     */

    @Test
    public void testConf() {

        try {
            System.out.println("=====================");
//            zk.exists("/xxoo1",myWatcher,myWatcher,"asd");
//            System.out.println("********************");
//            zk.exists("/xxoo2",myWatcher,myWatcher,"asd");
//            System.err.println("=====================");

            myWatcher.aWait();
            while (true){
                System.out.println("*************");
                System.out.println(myConf.getInfo());
//                zk.exists("/xxoo2",myWatcher,myWatcher,"asd");
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(10000);
            System.out.println("===========结束==========");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}



