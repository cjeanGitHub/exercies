/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TestRedisDemo
 * Author:   14172
 * Date:     2019/12/4 17:08
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cjean.spring.redis.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.hash.Jackson2HashMapper;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * @author 14172
 * @create 2019/12/4
 * @since 1.0.0
 */
@Component
public class TestRedisDemo {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    @Qualifier("getMyStringRedisTemplate")
    StringRedisTemplate myStringRedisTemplate;

    public void testOp(){


        Jackson2HashMapper jh1 = new Jackson2HashMapper(objectMapper,false);

        Address address = new Address();
        address.setPort(27000);
        address.setProvince("山东");

        Person person = new Person();
        person.setAddress(address);
        person.setAge(12);
        person.setName("tom");

        myStringRedisTemplate.opsForHash().putAll("person",jh1.toHash(person));

        System.out.println(myStringRedisTemplate.opsForHash().entries("person"));





    }

    public void test(){
        //会将key 以string类型进行对redis数据库赋值 增加序列化  redis 的key 是  \xac\xed\x00\x05t\x00\x04name
        //但是 客户端会自己进行编、解码
        redisTemplate.opsForValue().set("name","tom");
        String name = redisTemplate.opsForValue().get("name").toString();
        System.out.println("name："+name);

        // ********************

        //会将key 以string类型进行对redis数据库赋值 不会增加序列化  就是redis 的key就是 name2
        stringRedisTemplate.opsForValue().set("name2","name2");
        String name2 = stringRedisTemplate.opsForValue().get("name2").toString();
        System.out.println("name2："+name2);

        stringRedisTemplate.opsForHash().put("user","name","tony");

        redisTemplate.opsForHash().put("user2","name2","tony2");

        System.out.println("user:"+stringRedisTemplate.opsForHash().entries("user"));
        System.out.println("user2:"+redisTemplate.opsForHash().entries("user2"));

// ********************
        Jackson2HashMapper jh1 = new Jackson2HashMapper(objectMapper,false);
        Address address = new Address();
        address.setPort(27000);
        address.setProvince("山东");

        stringRedisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
        stringRedisTemplate.opsForHash().putAll("adress",jh1.toHash(address));

        System.out.println(stringRedisTemplate.opsForHash().entries("adress"));

// ********************

        Person person = new Person();
        person.setAddress(address);
        person.setAge(12);
        person.setName("tom");

        stringRedisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
        stringRedisTemplate.opsForHash().putAll("person",jh1.toHash(person));

        System.out.println(stringRedisTemplate.opsForHash().entries("person"));

// ********************

    }

}
