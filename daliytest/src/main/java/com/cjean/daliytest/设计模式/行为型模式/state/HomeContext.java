package com.cjean.daliytest.���ģʽ.��Ϊ��ģʽ.state;

public class HomeContext 
{
	private State state;

	public void setState(State s) {
		System.err.println("״̬������...");
		this.state = s;
		state.handle();
	}
	
	
}
