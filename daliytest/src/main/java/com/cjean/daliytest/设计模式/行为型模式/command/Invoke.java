package com.cjean.daliytest.���ģʽ.��Ϊ��ģʽ.command;

public class Invoke {
	
	private Command command;
	
	
	public Invoke(Command command) {
		super();
		this.command = command;
	}


	public void call() {
		System.out.println("Invoke--call()�������������");
		//��������ǰ
		//��������ǰ�߼�...
		command.execute();
		//���������
		//����������߼�...
	}
}
