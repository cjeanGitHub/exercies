/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MyStringRedisTemplate
 * Author:   14172
 * Date:     2019/12/4 21:38
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cjean.spring.redis.redis;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * @author 14172
 * @create 2019/12/4
 * @since 1.0.0
 */
@Configuration
public class MyStringRedisTemplate {
    @Bean
    public StringRedisTemplate getMyStringRedisTemplate(RedisConnectionFactory rcf){
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(rcf);
        stringRedisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));

        return stringRedisTemplate;
    }

}
