/**
 * Copyright (C), 2015-2019, XXX���޹�˾
 * FileName: TestJedisDemo
 * Author:   14172
 * Date:     2019/11/14 0:14
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
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
    private static JedisPool jedisPool;//ע��JedisPool

    public static void main(String[] args) {
//��ȡShardedJedis����
        Jedis jedis = jedisPool.getResource();
        //�����ֵ��
        jedis.set("key2","hello jedis one");
        //����ShardedJedisʵ��
        jedis.close();
    }
}
