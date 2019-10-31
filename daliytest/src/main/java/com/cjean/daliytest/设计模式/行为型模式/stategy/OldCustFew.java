package com.cjean.daliytest.设计模式.行为型模式.stategy;

public class OldCustFew implements Stategy {

	@Override
	public double getPrice(double price) {
		System.out.println("OldCustFew:打85折");
		return (price*0.85);
	}

}
