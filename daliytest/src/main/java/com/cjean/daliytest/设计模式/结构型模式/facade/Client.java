package com.cjean.daliytest.设计模式.结构型模式.facade;

public class Client {

	public static void main(String[] args) {
		String name = "小张";
		//当 不 使用外观模式时：
		Bank bank = new BankImpl(name);
		Bureau bureau = new BureauImpl(name);
		System.out.println("**********************");
		//当 使用外观模式时：
		Facade facade = new FacadeImpl(name);
	}

}
