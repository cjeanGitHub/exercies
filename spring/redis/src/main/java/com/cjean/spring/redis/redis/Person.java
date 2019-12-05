/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Person
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
public class Person {

    private String name;
    private int age;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
