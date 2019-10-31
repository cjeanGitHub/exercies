package com.cjean.daliytest.设计模式.行为型模式.templetMethod;

public abstract class BankTempletMethod {
	public void takeNumber() {
		System.out.println("取号...");
	}
	
	public abstract void transact();//钩子方法，不确定办理什么业务，这个有客户来自己确定
	
	public void evalute() {
		System.out.println("服务评价...");
	}
	
	public void process() {
		takeNumber();
		transact();//钩子算法
		evalute();
	}
}
