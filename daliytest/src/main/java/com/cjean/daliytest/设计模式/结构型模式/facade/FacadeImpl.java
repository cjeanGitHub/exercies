package com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.facade;

public class FacadeImpl implements Facade {
	private String name;
	
	public FacadeImpl(String name) {
		super();
		this.name = name;
		System.out.println(name+"�����ģʽ�ˣ���");
		Bank bank = new BankImpl(name);
		Bureau bureau = new BureauImpl(name);
	}
}
