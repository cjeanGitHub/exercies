package com.cjean.daliytest.���ģʽ.��Ϊ��ģʽ.command;

public class Client {

	public static void main(String[] args) {
		Command command = new ConcretCommand(new Receiver());
		
		Invoke invoke = new Invoke(command);
		invoke.call();
		
	}

}
