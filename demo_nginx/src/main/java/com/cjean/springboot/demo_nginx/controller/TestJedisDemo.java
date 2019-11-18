/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TestJedisDemo
 * Author:   14172
 * Date:     2019/11/14 0:14
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cjean.springboot.demo_nginx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author 14172
 * @create 2019/11/14
 * @since 1.0.0
 */
public class TestJedisDemo {
    @Autowired
    private static JedisPool jedisPool;//注入JedisPool

    public static void main(String[] args) {
//获取ShardedJedis对象
        Jedis jedis = jedisPool.getResource();
        //存入键值对
        jedis.set("key2","hello jedis one");
        //回收ShardedJedis实例
        jedis.close();
    }
}
