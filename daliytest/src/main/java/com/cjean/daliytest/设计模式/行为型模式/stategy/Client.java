package com.cjean.daliytest.���ģʽ.��Ϊ��ģʽ.stategy;

public class Client {

	public static void main(String[] args) {
		Stategy oldCustFew = new OldCustFew();
		
		Context context = new Context(oldCustFew);
		context.getPrice(100);
	}

}
