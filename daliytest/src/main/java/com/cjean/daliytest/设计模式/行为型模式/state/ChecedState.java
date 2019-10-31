package com.cjean.daliytest.设计模式.行为型模式.state;

public class ChecedState implements State
{

	@Override
	public void handle() {
		System.out.println("有人入住了！！");
	}

}
