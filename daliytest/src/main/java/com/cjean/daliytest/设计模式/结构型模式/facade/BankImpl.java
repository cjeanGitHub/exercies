package com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.facade;

public class BankImpl implements Bank {
	private String name;
	
	public BankImpl(String name) {
		super();
		this.name = name;
		System.out.println(name+"���ˣ���");
		mes();
	}

	@Override
	public void mes() {
		System.out.println("�������п�������");
	}

}
