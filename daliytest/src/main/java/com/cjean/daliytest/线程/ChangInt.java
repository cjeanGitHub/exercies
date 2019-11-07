/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: aaaaaa
 * Author:   14172
 * Date:     2019/11/7 19:25
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cjean.daliytest.线程;

/**
 * @author 14172
 * @create 2019/11/7
 * @since 1.0.0
 */
public class ChangInt {
    public static void main(String[] args) {
        int a = 4;
        int b = 9;
//        a=a^b;
//        b=a^b;
//        a=a^b;
//        0000   0100   4
//        0000   1001   9
//        0000   1101
//
//0000   0100   4
//0000   0101   5
//0000   0001   1
//
//        0000   0101   5
//        0000   0001   1
//        0000   0100   4
//
//        0000   0001   1
//        0000   0100   4
//        0000   0101   5



        System.out.println(1^4);
        System.out.println(a^b);//a^b
        System.out.println(a^b^b);//b
        System.out.println(a^b   ^a^b^b);//a
    }
}
