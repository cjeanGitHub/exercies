package com.cjean.daliytest.���ģʽ.��Ϊ��ģʽ.stategy;

public class OldCustMany implements Stategy {

	@Override
	public double getPrice(double price) {
		System.out.println("OldCustMany:��8��");
		return (price*0.8);
	}

}
