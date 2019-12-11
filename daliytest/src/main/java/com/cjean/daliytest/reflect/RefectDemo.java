package com.cjean.daliytest.reflect;

import com.cjean.daliytest.�߳�.threadlocal.ThreadLocalApple;

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
        Class clazz = Class.forName("com.cjean.daliytest.�߳�.threadlocal.ThreadLocalApple"); // �� 3 ��
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
     *  ��ȡ ����class ��3�з�ʽ  ֻ��ȡ ���������� �ͻ�ȡ ���е��ļ����� ����һ������ ����ȡ��setter �ļ�����ֵʱ��Ҫ�� ���Խ���setAccessible Ϊtrue
     *      ���ã�Ҫ��Ȼ��Ĭ�ϻ�������Ϊfalse�Ļ�  ��ȡ˽������ �ر��Ƿ��������
    * @param: []
    * @return: void
    * @author: chu_c
    * @date: 2019-11-11
    */
    public static void getClassFields() throws Exception{

        //���� Class �����3�з�ʽ
//        ThreadLocalApple t1 = new ThreadLocalApple();
//        Class tClass = t1.getClass();//  ��һ��

        //  Class tClass = ThreadLocalApple.class;//  �� 2 ��
        Class clazz = Class.forName("com.cjean.daliytest.�߳�.threadlocal.ThreadLocalApple"); // �� 3 ��
        ThreadLocalApple threadLocalApple = (ThreadLocalApple) clazz.newInstance();

        // fiedl ��ȡ class �ļ��� ���� ����
        System.out.println("====��ȡ class �ļ���  ��������=====");
        Field[] fields = clazz.getFields();

        for (Field filed : fields) {
            System.out.println(filed.getType() + "========" + filed.getName() + "---" + filed.get(threadLocalApple));
        }

        //��ȡ class �ļ���  ˽������
        System.out.println("====��ȡ class �ļ���  ���� ����  ��� setAccessible Ĭ����false �����Զ� ˽�����Ի�ȡֵ=====");
        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field filed : declaredFields) {
//            filed.setAccessible(false);//�� �����Ի�ȡ�� ˽�������е�ֵ  �����ǿ�ƻ�ȡ�ᱨ��  IllegalAccessException:�Ƿ�����
            filed.setAccessible(true);//�� ���Ի�ȡ�� ˽�������е�ֵ
            System.out.println(filed.getType() + "========" + filed.getName() + "---" + filed.get(threadLocalApple));
        }
    }
}
