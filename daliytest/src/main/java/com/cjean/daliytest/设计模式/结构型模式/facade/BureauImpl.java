package com.cjean.daliytest.设计模式.结构型模式.facade;

public class BureauImpl implements Bureau {
	private String name;
	
	public BureauImpl(String name) {
		super();
		this.name = name;
		System.out.println(name+"来了！！");
		mes();
	}

	@Override
	public void mes() {
		System.out.println("我来税务局注册公司！！");
	}

}
