package com.cjean.daliytest.设计模式.结构型模式.facade;

public class BankImpl implements Bank {
	private String name;
	
	public BankImpl(String name) {
		super();
		this.name = name;
		System.out.println(name+"来了！！");
		mes();
	}

	@Override
	public void mes() {
		System.out.println("我来银行开户！！");
	}

}
