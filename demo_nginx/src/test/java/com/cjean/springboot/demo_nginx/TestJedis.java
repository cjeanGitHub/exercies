package com.cjean.springboot.demo_nginx;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class TestJedis {

    /**
     * 功能描述: <br>
     *          xml配置文件 单测试 Jedis
     No such property: code for class: Script1
     * @return:
     * @since: 1.0.0
     * @Author:14172
     * @Date: 2019/11/13 23:47
     */
    @Test
    public void t3() {



    }
    /**
     * 功能描述: <br>
     *          测试 Jedis链接池
     No such property: code for class: Script1
     * @return:
     * @since: 1.0.0
     * @Author:14172
     * @Date: 2019/11/13 23:47
     */
    @Test
    public void t2() {
        // Reids 池 设置信息
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(20);
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setMinIdle(8);

        String host = "192.168.101.136";// Reids 服务器地址
        int port = 6379;// Reids 服务开放端口
        String password = "261875";// Reids 服务密码
        int timeOut = 6379;// Reids 读写 超时时间
        // Reids 实例初始化 // Reids池
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,host,port,timeOut,password);

        // Reids 实力初始化
        Jedis jedis = jedisPool.getResource();

        System.out.println("连接本地的Redis服务器成功");
        //查看服务是否运行
        System.out.println("服务正在运行：" + jedis.ping());
        System.out.println(jedis.get("name"));

        System.out.println("*********************");
        jedis.append("name","--append");
        System.out.println(jedis.get("name"));

        jedis.close();


    }

    /**
     * 功能描述: <br>
     *          单测 Jedis链接
     No such property: code for class: Script1
     * @return:
     * @since: 1.0.0
     * @Author:14172
     * @Date: 2019/11/13 23:47
     */
    @Test
    public void t1() {
        String host = "192.168.101.136";
        int port = 6379;
        String password = "261875";
        Jedis jedis = new Jedis(host, port);
        //jedis连接设置的密码
        jedis.auth(password);
        //设置key
        System.out.println("连接本地的Redis服务器成功");
        //查看服务是否运行
        System.out.println("服务正在运行：" + jedis.ping());
        System.out.println(jedis.get("name"));
        jedis.close();

    }
}



