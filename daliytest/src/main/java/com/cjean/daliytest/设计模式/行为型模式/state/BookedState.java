package com.cjean.daliytest.设计模式.行为型模式.state;

public class BookedState implements State
{

	@Override
	public void handle() {
		System.out.println("有人预定！！");
	}

}
