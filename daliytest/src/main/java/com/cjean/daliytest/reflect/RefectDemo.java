package com.cjean.daliytest.reflect;

import com.cjean.daliytest.线程.threadlocal.ThreadLocalApple;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName:RefectDemo
 * @Description:
 * @author: chu_c
 * @date: 2019-11-11
 */

public class RefectDemo {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("com.cjean.daliytest.线程.threadlocal.ThreadLocalApple"); // 第 3 种
        ThreadLocalApple threadLocalApple = (ThreadLocalApple) clazz.newInstance();

        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();

        for (Constructor constructor:declaredConstructors){
            constructor.setAccessible(true);
            System.out.println("======"+constructor.getName()+"========"+constructor.getModifiers());
        }

        System.out.println("==============");

        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method:declaredMethods){
            method.setAccessible(true);
            System.out.println("======"+method.getName()+"========"+method.getModifiers());
            System.out.println("======"+method.getReturnType()+"========"+method.getParameters());
        }

    }

    /***
    * @Description:
     *  获取 对象class 有3中方式  只获取 公开的属性 和获取 所有的文件属性 各有一个方法 当获取、setter 文件属性值时需要对 属性进行setAccessible 为true
     *      设置，要不然是默认或者设置为false的话  获取私有属性 回报非法侵入错误
    * @param: []
    * @return: void
    * @author: chu_c
    * @date: 2019-11-11
    */
    public static void getClassFields() throws Exception{

        //创建 Class 对象的3中方式
//        ThreadLocalApple t1 = new ThreadLocalApple();
//        Class tClass = t1.getClass();//  第一种

        //  Class tClass = ThreadLocalApple.class;//  第 2 种
        Class clazz = Class.forName("com.cjean.daliytest.线程.threadlocal.ThreadLocalApple"); // 第 3 种
        ThreadLocalApple threadLocalApple = (ThreadLocalApple) clazz.newInstance();

        // fiedl 获取 class 文件的 公开 属性
        System.out.println("====获取 class 文件的  公开属性=====");
        Field[] fields = clazz.getFields();

        for (Field filed : fields) {
            System.out.println(filed.getType() + "========" + filed.getName() + "---" + filed.get(threadLocalApple));
        }

        //获取 class 文件的  私有属性
        System.out.println("====获取 class 文件的  所有 属性  如果 setAccessible 默认是false 不可以对 私有属性获取值=====");
        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field filed : declaredFields) {
//            filed.setAccessible(false);//将 不可以获取到 私有属性中的值  ，如果强制获取会报错  IllegalAccessException:非法侵入
            filed.setAccessible(true);//将 可以获取到 私有属性中的值
            System.out.println(filed.getType() + "========" + filed.getName() + "---" + filed.get(threadLocalApple));
        }
    }
}
