package com.cjean.springboot.demo_nginx;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class TestJedis {

    /**
     * ��������: <br>
     *          xml�����ļ� ������ Jedis
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
     * ��������: <br>
     *          ���� Jedis���ӳ�
     No such property: code for class: Script1
     * @return:
     * @since: 1.0.0
     * @Author:14172
     * @Date: 2019/11/13 23:47
     */
    @Test
    public void t2() {
        // Reids �� ������Ϣ
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(20);
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setMinIdle(8);

        String host = "192.168.101.136";// Reids ��������ַ
        int port = 6379;// Reids ���񿪷Ŷ˿�
        String password = "261875";// Reids ��������
        int timeOut = 6379;// Reids ��д ��ʱʱ��
        // Reids ʵ����ʼ�� // Reids��
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,host,port,timeOut,password);

        // Reids ʵ����ʼ��
        Jedis jedis = jedisPool.getResource();

        System.out.println("���ӱ��ص�Redis�������ɹ�");
        //�鿴�����Ƿ�����
        System.out.println("�����������У�" + jedis.ping());
        System.out.println(jedis.get("name"));

        System.out.println("*********************");
        jedis.append("name","--append");
        System.out.println(jedis.get("name"));

        jedis.close();


    }

    /**
     * ��������: <br>
     *          ���� Jedis����
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
        //jedis�������õ�����
        jedis.auth(password);
        //����key
        System.out.println("���ӱ��ص�Redis�������ɹ�");
        //�鿴�����Ƿ�����
        System.out.println("�����������У�" + jedis.ping());
        System.out.println(jedis.get("name"));
        jedis.close();

    }
}



