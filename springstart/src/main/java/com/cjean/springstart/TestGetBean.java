package com.cjean.springstart; /**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TestGetBean
 * Author:   14172
 * Date:     2019/12/11 9:24
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author 14172
 * @create 2019/12/11
 * @since 1.0.0
 */
public class TestGetBean implements ApplicationContextAware {

    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        TestGetBean.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void main(String[] args) {


        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        Person person = (Person)classPathXmlApplicationContext.getBean("person");
        System.out.println(person.getAge());
        classPathXmlApplicationContext.getBean("food");
        System.out.println(person.getFood().getApple());


        String[] beans = TestGetBean.getApplicationContext().getBeanDefinitionNames();
        for (String beanName : beans) {
            Class<?> beanType = TestGetBean.getApplicationContext()
                    .getType(beanName);
            System.out.println("BeanName:" + beanName);
            System.out.println("Bean的类型：" + beanType);
            System.out.println("Bean所在的包：" + beanType.getPackage());
            System.out.println("Bean：" + TestGetBean.getApplicationContext().getBean(
                    beanName));
        }

    }
}
