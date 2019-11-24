/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MyConf
 * Author:   14172
 * Date:     2019/11/23 15:23
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cjean.spring.two.zkconfig.zkUtil;

import org.apache.zookeeper.ZooKeeper;

/**
 * @author 14172
 * @create 2019/11/23
 * @since 1.0.0
 */
public class MyConf {

        private String info ;
        private ZooKeeper zk ;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
