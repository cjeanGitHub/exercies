package com.cjean.daliytest.string;

/**
 * @ClassName:StringDemo
 * @Description:
 * @author: chu_c
 * @date: 2019-11-05
 */

public class StringDemo {
    public static void main(String[] args) {

        // String对象的intern方法会得到字符串对象在常量池中对应的版本的引用（如果常量池中有一个字符串与String对象的equals结果是true）
        // ，如果常量池中没有对应的字符串，则该字符串将被添加到常量池中，然后返回常量池中字符串的引用
        /***
         System.out.println(s1 == s6.intern());// true
         System.out.println(s2 == s2.intern());// false
         */
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";

//字符串的+操作其本质是创建了StringBuilder对象进行append操作，然后将拼接后的StringBuilder对象用toString方法处理成String对象
        String s6 = s3 + s4;

        System.out.println(s6 == s2);// false

        System.out.println(s1 == s2);// false
        System.out.println(s1 == s5);// true
        System.out.println(s1 == s6);// false
        System.out.println(s1 == s6.intern());// true
        System.out.println(s2 == s2.intern());// false
    }
}
