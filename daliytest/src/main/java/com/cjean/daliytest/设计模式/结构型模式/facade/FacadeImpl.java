package com.cjean.daliytest.设计模式.结构型模式.facade;

public class FacadeImpl implements Facade {
	private String name;
	
	public FacadeImpl(String name) {
		super();
		this.name = name;
		System.out.println(name+"来外观模式了！！");
		Bank bank = new BankImpl(name);
		Bureau bureau = new BureauImpl(name);
	}
}
