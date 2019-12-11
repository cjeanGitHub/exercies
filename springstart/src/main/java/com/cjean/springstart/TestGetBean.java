package com.cjean.springstart; /**
 * Copyright (C), 2015-2019, XXX���޹�˾
 * FileName: TestGetBean
 * Author:   14172
 * Date:     2019/12/11 9:24
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 14172
 * @create 2019/12/11
 * @since 1.0.0
 */
public class TestGetBean {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        Person person = (Person)classPathXmlApplicationContext.getBean("person");
        System.out.println(person.getAge());
        classPathXmlApplicationContext.getBean("food");
        System.out.println(person.getFood().getApple());
    }
}
