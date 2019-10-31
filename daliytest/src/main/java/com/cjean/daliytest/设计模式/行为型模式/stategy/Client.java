package com.cjean.daliytest.设计模式.行为型模式.stategy;

public class Client {

	public static void main(String[] args) {
		Stategy oldCustFew = new OldCustFew();
		
		Context context = new Context(oldCustFew);
		context.getPrice(100);
	}

}
