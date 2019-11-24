/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: NginxFirst
 * Author:   14172
 * Date:     2019/10/31 16:24
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cjean.springboot.demo_nginx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author 14172
 * @create 2019/10/31
 * @since 1.0.0
 */
@RestController
public class NginxFirst {

    @Value("${server.port}")
    private String port;

    @Autowired
    @Qualifier("jedisPool")
    private JedisPool jedisPool;//注入JedisPool

    @RequestMapping("/one1")
    public String getSome11(){
//获取ShardedJedis对象
        Jedis jedis = jedisPool.getResource();
        //存入键值对
        jedis.set("key2","hello jedis one");
        //回收ShardedJedis实例
        jedis.close();

        return "hahaah222a-one1-getSome11-"+port;
    }

    @RequestMapping("/one")
    public String getSome(){
        return "hahaah222a-one--"+port;
    }
    @RequestMapping("/")
    public String getSome2(){
        return "hahaah1112a----"+port;
    }



}
