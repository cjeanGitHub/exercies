package com.cjean.daliytest.reflect.client;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 题目意思  自定义 int 2个变量，打印输出变量的值；通过一个方法实现变量值更改的目的
 * <p>
 * 解决： 基本数据类型是无法达到目的的，但是可以将基本数据类型包装称为相对应的包装类进行输出
 *
 * @author chu_c
 */

public class ParamTranClient {

    public static void main(String[] args) {


        ParamTranClient p = new ParamTranClient();
//        getReflect();
        // 反射解决  基本类型 改变值的情况
        int a = 1;
        int b = 2;
        Integer c = a;
        Integer d = b;

        System.out.println("a:" + a + ",B：" + b);
        System.out.println("==============");

        test(c,d);
        a = c;
        b = d;
        System.out.println("a:" + a + ",B：" + b);
//
        //通过异或运算符达到数字交换的目的
//        System.out.println("a:" + a + ",B：" + b);
//        System.out.println("==============");
//        a = a^b;
//        b = a^b;
//        a = a^b;
//        System.out.println("a:" + a + ",B：" + b);

        //基本的数据交换达到 交换的目的
//        System.out.println("a:" + a + ",B：" + b);
//        System.out.println("==============");
//        int c = a;
//        a=b;
//        b=c;
//        System.out.println("a:" + a + ",B：" + b);

        //包装类型下的数字交换  基于java反射的方式
//        Integer a1 = 1;
//        Integer b1 = 3;
//        System.out.println("a1:" + a + ",b1：" + b1);
//        test(a1,b1);
//        System.out.println("==============");
//        System.out.println("a1:" + a + ",b1：" + b1);

    }
    /**
     * 交换int---by木木DR
     *
     * @param a
     * @param b
     */
    public static void test1(Integer a, Integer b) {
        try {
            Class clazz = Class.forName("com.cjean.daliytest.reflect.ParamTran");
            // 很重点   在获取方法、属性的前提  以及 反射方法 需要传入的 object对象都是 class 的实例化 即 clazz.newInstance（）；
            Object o = clazz.newInstance();
            Field c = clazz.getDeclaredField("c");
            c.setAccessible(true);//false
            System.out.println("======" + c.getType().getSimpleName() + "========");

            Object o3 = c.get(o);
            System.out.println("======" + o3 + "========");//Method method=

            c.set(o, 4);
            c.setInt(o, 8);
            System.out.println("======" + o3 + "========");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 交换int---by木木DR
     *
     * @param a
     * @param b
     */
    public static void test(Integer a, Integer b) {
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);//去除private
//去除final影响
//            Field modifiersField = Field.class.getDeclaredField("modifiers");
//            modifiersField.setAccessible(true);
//            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
//交换
            int temp = b;
            field.set(b, a);
            field.set(a, new Integer(temp));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void getReflect() {
        try {
            Class clazz = Class.forName("com.cjean.daliytest.reflect.ParamTran");
            Field a = clazz.getDeclaredField("a");
            System.out.println("======" + a.getType().getSimpleName() + "========");
            // 很重点   在获取方法、属性的前提  以及 反射方法 需要传入的 object对象都是 class 的实例化 即 clazz.newInstance（）；
            Object o = clazz.newInstance();
            Object o1 = a.get(o);
            System.out.println("======" + o1 + "========");
            System.out.println("==============");

            Field d = clazz.getDeclaredField("d");
            d.setAccessible(true);//防止 java的访问限制  就是私有或者没有办法访问到的数据
            System.out.println("======" + d.getType().getSimpleName() + "========");
            Object o2 = d.get(o);
            System.out.println("======" + o2 + "========");

            d.set(o, "ggggaa");
            o2 = d.get(o);
            System.out.println("======" + o2 + "========");
            System.out.println("==============");
            Field c = clazz.getDeclaredField("c");
            c.setAccessible(true);//false
            System.out.println("======" + c.getType().getSimpleName() + "========");

            Object o3 = c.get(o);
            System.out.println("======" + o3 + "========");

            c.set(o, 4);
            c.setInt(o, 8);
            System.out.println("======" + o3 + "========");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
