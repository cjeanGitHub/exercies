package com.cjean.daliytest.���ģʽ.��Ϊ��ģʽ.templetMethod;

public abstract class BankTempletMethod {
	public void takeNumber() {
		System.out.println("ȡ��...");
	}
	
	public abstract void transact();//���ӷ�������ȷ������ʲôҵ������пͻ����Լ�ȷ��
	
	public void evalute() {
		System.out.println("��������...");
	}
	
	public void process() {
		takeNumber();
		transact();//�����㷨
		evalute();
	}
}
