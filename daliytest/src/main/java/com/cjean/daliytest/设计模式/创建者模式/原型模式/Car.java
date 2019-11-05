package com.cjean.daliytest.设计模式.创建者模式.原型模式;

import java.io.Serializable;

/**
 * @ClassName:Car
 * @Description:
 * @author: chu_c
 * @date: 2019-11-05
 */

public class Car implements Serializable {
    private static final long serialVersionUID = 1L;

    private int maxSpeed;
    private String name;

    public Car(int maxSpeed, String name) {
        this.maxSpeed = maxSpeed;
        this.name = name;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "maxSpeed=" + maxSpeed +
                ", name='" + name + '\'' +
                '}';
    }
}
