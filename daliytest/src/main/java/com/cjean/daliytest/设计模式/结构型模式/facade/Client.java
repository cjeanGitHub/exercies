package com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.facade;

public class Client {

	public static void main(String[] args) {
		String name = "С��";
		//�� �� ʹ�����ģʽʱ��
		Bank bank = new BankImpl(name);
		Bureau bureau = new BureauImpl(name);
		System.out.println("**********************");
		//�� ʹ�����ģʽʱ��
		Facade facade = new FacadeImpl(name);
	}

}
