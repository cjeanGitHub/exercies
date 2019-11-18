package com.cjean.daliytest.设计模式.结构型模式.flyweight;

public class Client {

    public static void main(String[] args) {
        test01();
//        test02();

    }

    /***
     * @Description:
     *    创建相同的的对象
     * @param: []
     * @return: void
     * @author: chu_c
     * @date: 2019-11-12
     */
    static void test01() {
        ConcreteFlyWeight f1 = FlyWeightFactory.getKey("黑色");
        ConcreteFlyWeight f2 = FlyWeightFactory.getKey("白色");

        System.out.println("*******************");
        f1.setUnSharedConcreteFlyWeight(new UnSharedConcreteFlyWeight(1, 1));
        System.out.println("*******************");
        f1.Operation();
        f2.Operation();
        System.out.println("*******************");
        f2.setUnSharedConcreteFlyWeight(new UnSharedConcreteFlyWeight(2, 2));
        System.out.println("*******************");
        f1.Operation();
        f2.Operation();
        System.out.println("*******************");
    }

    /***
     * @Description:
     *    创建不同的对象
     * @param: []
     * @return: void
     * @author: chu_c
     * @date: 2019-11-12
     */
    static void test02() {
        ConcreteFlyWeight f1 = FlyWeightFactory.getKey("黑色");
        ConcreteFlyWeight f2 = FlyWeightFactory.getKey("白色");

        System.out.println("*******************");
        f1.setUnSharedConcreteFlyWeight(new UnSharedConcreteFlyWeight(1, 1));
        System.out.println("*******************");
        f1.Operation();
//		f2.Operation();
        System.out.println("*******************");
        f2.setUnSharedConcreteFlyWeight(new UnSharedConcreteFlyWeight(2, 1));
        System.out.println("*******************");
        f1.Operation();
        f2.Operation();
        System.out.println("*******************");
    }

}
