package com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.facade;

public class BureauImpl implements Bureau {
	private String name;
	
	public BureauImpl(String name) {
		super();
		this.name = name;
		System.out.println(name+"���ˣ���");
		mes();
	}

	@Override
	public void mes() {
		System.out.println("����˰���ע�ṫ˾����");
	}

}
