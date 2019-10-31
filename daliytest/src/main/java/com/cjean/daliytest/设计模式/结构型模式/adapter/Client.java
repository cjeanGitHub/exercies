package com.cjean.daliytest.设计模式.结构型模式.adapter;

public class Client {
	void testClassAdapter(Target t) {
		t.HandlReq();
	}

	public static void main(String[] args) {
		// 类适配器
/*		Adaptee adaptee = new Adaptee();
		Target t = new Adapter();
		Client client = new Client();
		client.testClassAdapter(t);*/
		
		// 对象适配器适配器
		Adaptee adaptee = new Adaptee();
		Target t = new Adapter2(adaptee);
		Client client = new Client();
		client.testClassAdapter(t);
	}

}
