package com.cjean.daliytest.util;

class A {

    static {
        System.out.print("1");
    }

    public A() {
        System.out.print("2");
    }
}

class B extends A{

    static {
        System.out.print("a");
    }

    public B() {
        System.out.print("b");
    }
}

public class Hello {

    public static void main(String[] args) {
        A ab = new B();
        System.out.println("======静态变量 有且只加载一次========");
        ab = new B();
        System.out.println("======静态变量 有且只加载一次========");
        B bb = new B();
        System.out.println("======静态变量 有且只加载一次========");
        A a = new A();
    }

}
