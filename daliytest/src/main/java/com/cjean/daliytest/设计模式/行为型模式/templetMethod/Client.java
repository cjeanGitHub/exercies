package com.cjean.daliytest.���ģʽ.��Ϊ��ģʽ.templetMethod;

public class Client {

	public static void main(String[] args) {
		BankTempletMethod brawMoney = new BrawMoney();// ʵ��ȡǮ��ģ�巽��
		brawMoney.process();
		
		
		BankTempletMethod takeMoney = new TakeMoney();// ʵ��ȡǮ��ģ�巽��
		takeMoney.process();
	}

}

class BrawMoney extends BankTempletMethod {// �ɿͻ���������ȷ�������أ���ô��ȷ��

	@Override
	public void transact() {
		System.out.println("������ȡǮ�ģ�����");
	}
	
}
class TakeMoney extends BankTempletMethod {// �ɿͻ���������ȷ�������أ���ô��ȷ��

	@Override
	public void transact() {
		System.out.println("��������Ǯ�ģ�����");
	}
	
}