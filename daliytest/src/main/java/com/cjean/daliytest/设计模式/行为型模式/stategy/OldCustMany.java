package com.cjean.daliytest.设计模式.行为型模式.stategy;

public class OldCustMany implements Stategy {

	@Override
	public double getPrice(double price) {
		System.out.println("OldCustMany:打8折");
		return (price*0.8);
	}

}
