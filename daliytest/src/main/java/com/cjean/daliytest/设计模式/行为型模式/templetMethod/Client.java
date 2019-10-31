package com.cjean.daliytest.设计模式.行为型模式.templetMethod;

public class Client {

	public static void main(String[] args) {
		BankTempletMethod brawMoney = new BrawMoney();// 实现取钱的模板方法
		brawMoney.process();
		
		
		BankTempletMethod takeMoney = new TakeMoney();// 实现取钱的模板方法
		takeMoney.process();
	}

}

class BrawMoney extends BankTempletMethod {// 由客户来决定不确定的因素，怎么来确定

	@Override
	public void transact() {
		System.out.println("我是来取钱的！！！");
	}
	
}
class TakeMoney extends BankTempletMethod {// 由客户来决定不确定的因素，怎么来确定

	@Override
	public void transact() {
		System.out.println("我是来存钱的！！！");
	}
	
}