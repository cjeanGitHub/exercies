package com.cjean.daliytest.���ģʽ.��Ϊ��ģʽ.stategy;

public class NewCustMany implements Stategy {

	@Override
	public double getPrice(double price) {
		System.out.println("NewCustMany:��9��");
		return (price*0.9);
	}

}
