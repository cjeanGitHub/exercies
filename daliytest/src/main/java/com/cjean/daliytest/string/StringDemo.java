package com.cjean.daliytest.string;

/**
 * @ClassName:StringDemo
 * @Description:
 * @author: chu_c
 * @date: 2019-11-05
 */

public class StringDemo {
    public static void main(String[] args) {

        // String�����intern������õ��ַ��������ڳ������ж�Ӧ�İ汾�����ã��������������һ���ַ�����String�����equals�����true��
        // �������������û�ж�Ӧ���ַ���������ַ���������ӵ��������У�Ȼ�󷵻س��������ַ���������
        /***
         System.out.println(s1 == s6.intern());// true
         System.out.println(s2 == s2.intern());// false
         */
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";

//�ַ�����+�����䱾���Ǵ�����StringBuilder�������append������Ȼ��ƴ�Ӻ��StringBuilder������toString���������String����
        String s6 = s3 + s4;

        System.out.println(s6 == s2);// false

        System.out.println(s1 == s2);// false
        System.out.println(s1 == s5);// true
        System.out.println(s1 == s6);// false
        System.out.println(s1 == s6.intern());// true
        System.out.println(s2 == s2.intern());// false
    }
}
