package com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.adapter;

public class Client {
	void testClassAdapter(Target t) {
		t.HandlReq();
	}

	public static void main(String[] args) {
		// ��������
/*		Adaptee adaptee = new Adaptee();
		Target t = new Adapter();
		Client client = new Client();
		client.testClassAdapter(t);*/
		
		// ����������������
		Adaptee adaptee = new Adaptee();
		Target t = new Adapter2(adaptee);
		Client client = new Client();
		client.testClassAdapter(t);
	}

}
