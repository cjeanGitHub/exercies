package com.cjean.daliytest.设计模式.行为型模式.command;

public class Invoke {
	
	private Command command;
	
	
	public Invoke(Command command) {
		super();
		this.command = command;
	}


	public void call() {
		System.out.println("Invoke--call()：发送命令。。。");
		//发送命令前
		//发送命令前逻辑...
		command.execute();
		//发送命令后
		//发送命令后逻辑...
	}
}
