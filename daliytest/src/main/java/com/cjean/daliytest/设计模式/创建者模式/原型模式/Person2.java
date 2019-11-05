package com.cjean.daliytest.���ģʽ.������ģʽ.ԭ��ģʽ;

import java.io.Serializable;

/**
 * @ClassName:Person
 * @Description: ͨ��ʵ�� cloneable �ķ�ʽʵ��ǳ�Ŀ�¡
 * @author: chu_c
 * @date: 2019-11-05
 */

public class Person2 implements Cloneable {

    private String name;
    private int age;
    private Car car;

    public Person2(String name, int age, Car car) {
        this.name = name;
        this.age = age;
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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
