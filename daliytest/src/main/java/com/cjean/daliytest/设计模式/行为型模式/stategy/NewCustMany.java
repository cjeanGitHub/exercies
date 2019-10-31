package com.cjean.daliytest.设计模式.行为型模式.stategy;

public class NewCustMany implements Stategy {

	@Override
	public double getPrice(double price) {
		System.out.println("NewCustMany:打9折");
		return (price*0.9);
	}

}
