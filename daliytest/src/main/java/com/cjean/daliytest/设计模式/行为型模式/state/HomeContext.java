package com.cjean.daliytest.设计模式.行为型模式.state;

public class HomeContext 
{
	private State state;

	public void setState(State s) {
		System.err.println("状态控制中...");
		this.state = s;
		state.handle();
	}
	
	
}
