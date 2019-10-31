package com.cjean.daliytest.设计模式.结构型模式.bridge;

public class Client {

	public static void main(String[] args) {
		Desktop c = new Desktop(new LenovoBrand());
		c.sale();
		System.out.println("**************");
		Laptoptop l = new Laptoptop(new LenovoBrand());
		l.sale();
		System.out.println("**************");
		Laptoptop l2 = new Laptoptop(new ShenzhouBrand());
		l2.sale();
		System.out.println("**************");
		
	}

}
