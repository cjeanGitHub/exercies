package com.cjean.daliytest.reflect.client;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ��Ŀ��˼  �Զ��� int 2����������ӡ���������ֵ��ͨ��һ������ʵ�ֱ���ֵ���ĵ�Ŀ��
 * <p>
 * ����� ���������������޷��ﵽĿ�ĵģ����ǿ��Խ������������Ͱ�װ��Ϊ���Ӧ�İ�װ��������
 *
 * @author chu_c
 */

public class ParamTranClient {

    public static void main(String[] args) {


        ParamTranClient p = new ParamTranClient();
//        getReflect();
        // ������  �������� �ı�ֵ�����
        int a = 1;
        int b = 2;
        Integer c = a;
        Integer d = b;

        System.out.println("a:" + a + ",B��" + b);
        System.out.println("==============");

        test(c,d);
        a = c;
        b = d;
        System.out.println("a:" + a + ",B��" + b);
//
        //ͨ�����������ﵽ���ֽ�����Ŀ��
//        System.out.println("a:" + a + ",B��" + b);
//        System.out.println("==============");
//        a = a^b;
//        b = a^b;
//        a = a^b;
//        System.out.println("a:" + a + ",B��" + b);

        //���������ݽ����ﵽ ������Ŀ��
//        System.out.println("a:" + a + ",B��" + b);
//        System.out.println("==============");
//        int c = a;
//        a=b;
//        b=c;
//        System.out.println("a:" + a + ",B��" + b);

        //��װ�����µ����ֽ���  ����java����ķ�ʽ
//        Integer a1 = 1;
//        Integer b1 = 3;
//        System.out.println("a1:" + a + ",b1��" + b1);
//        test(a1,b1);
//        System.out.println("==============");
//        System.out.println("a1:" + a + ",b1��" + b1);

    }
    /**
     * ����int---byľľDR
     *
     * @param a
     * @param b
     */
    public static void test1(Integer a, Integer b) {
        try {
            Class clazz = Class.forName("com.cjean.daliytest.reflect.ParamTran");
            // ���ص�   �ڻ�ȡ���������Ե�ǰ��  �Լ� ���䷽�� ��Ҫ����� object������ class ��ʵ���� �� clazz.newInstance������
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
     * ����int---byľľDR
     *
     * @param a
     * @param b
     */
    public static void test(Integer a, Integer b) {
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);//ȥ��private
//ȥ��finalӰ��
//            Field modifiersField = Field.class.getDeclaredField("modifiers");
//            modifiersField.setAccessible(true);
//            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
//����
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
            // ���ص�   �ڻ�ȡ���������Ե�ǰ��  �Լ� ���䷽�� ��Ҫ����� object������ class ��ʵ���� �� clazz.newInstance������
            Object o = clazz.newInstance();
            Object o1 = a.get(o);
            System.out.println("======" + o1 + "========");
            System.out.println("==============");

            Field d = clazz.getDeclaredField("d");
            d.setAccessible(true);//��ֹ java�ķ�������  ����˽�л���û�а취���ʵ�������
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
