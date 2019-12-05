/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Address
 * Author:   14172
 * Date:     2019/12/4 20:37
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cjean.spring.redis.redis;

/**
 * @author 14172
 * @create 2019/12/4
 * @since 1.0.0
 */
public class Address {
    private int port;
    private String province;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
