package com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.flyweight;

public class Client {

	public static void main(String[] args) {
		ConcreteFlyWeight f1 = FlyWeightFactory.getKey("��ɫ") ;
		ConcreteFlyWeight f2 = FlyWeightFactory.getKey("��ɫ") ;
		
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
