package com.cjean.daliytest.设计模式.结构型模式.flyweight;

public class Client {

	public static void main(String[] args) {
		ConcreteFlyWeight f1 = FlyWeightFactory.getKey("黑色") ;
		ConcreteFlyWeight f2 = FlyWeightFactory.getKey("黑色") ;
		
		System.out.println(f1);
		System.out.println(f2);
		System.out.println("*******************");
		f1.setUnSharedConcreteFlyWeight(new UnSharedConcreteFlyWeight(1, 1));
		System.out.println(f1);
		System.out.println(f2);
		System.out.println("*******************");
		f1.Operation();
		f2.Operation();
		System.out.println("*******************");
		f2.setUnSharedConcreteFlyWeight(new UnSharedConcreteFlyWeight(2, 2));
		System.out.println(f1);
		System.out.println(f2);
		System.out.println("*******************");
		f1.Operation();
		f2.Operation();
		System.out.println("*******************");
		
	}

}
