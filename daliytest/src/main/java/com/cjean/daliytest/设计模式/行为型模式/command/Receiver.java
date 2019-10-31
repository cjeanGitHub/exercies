package com.cjean.daliytest.设计模式.行为型模式.command;

public class Receiver {
	public void receive() {
		System.out.println("我来执行任务了！！");
	}
	
	public void action() {
		
		/**
		 * - 接收者执行与请求相关的操作，具体实现对请求的业务处理
			-未抽象前，实际执行操作内容的对象
		 */
		//执行前
		//。。。逻辑
		System.out.println("Receiver--action()：我来执行任务了！！");
		//执行后
		//。。。逻辑
	}
}
