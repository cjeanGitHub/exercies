package com.cjean.daliytest.���ģʽ.��Ϊ��ģʽ.stategy;

public class OldCustFew implements Stategy {

	@Override
	public double getPrice(double price) {
		System.out.println("OldCustFew:��85��");
		return (price*0.85);
	}

}
