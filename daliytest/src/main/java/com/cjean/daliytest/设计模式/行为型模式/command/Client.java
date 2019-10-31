package com.cjean.daliytest.设计模式.行为型模式.command;

public class Client {

	public static void main(String[] args) {
		Command command = new ConcretCommand(new Receiver());
		
		Invoke invoke = new Invoke(command);
		invoke.call();
		
	}

}
