package com.cjean.springstart; /**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Person
 * Author:   14172
 * Date:     2019/12/11 9:24
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import java.io.Serializable;

/**
 * @author 14172
 * @create 2019/12/11
 * @since 1.0.0
 */
public class Person implements Serializable {

    private String name;
    private int age;
    private Food food;
    private Car car;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

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

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
