package com.cjean.daliytest.设计模式.创建者模式.工厂模式.simplefactory;

public class TestFactory {
	
	public static void main(String[] args) {
		
		
		
		// 通过调用工厂中的静态方法来创建对象
//		testSimpFactory();
		// 无工厂模式
	//	testNoFactory();
	}
	// 通过调用工厂中的实现方法来创建对象
	public static void testSimpFactory() {
		
		//通过传入参数确定车类型
		Simp_Car audi1 = Simp_CarFactory.getCar("audi");
		Simp_Car byd1 = Simp_CarFactory.getCar("byd");
		audi1.type();
		byd1.type();
		System.out.println("=====getCar=======");
		// 通过调用工厂中的实现方法来创建对象
		Simp_Car audi = Simp_CarFactory.getAudi();
		Simp_Car byd = Simp_CarFactory.getByd();
		//===
		audi.type();
		byd.type();
	}
	// 无工厂模式
	public static void testNoFactory() {
		Simp_Car audi = new Simp_Audi();
		Simp_Car byd = new Simp_Byd();
		
		audi.type();
		byd.type();
		
	}
}
