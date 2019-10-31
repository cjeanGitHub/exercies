package com.cjean.daliytest.设计模式.行为型模式.state;

public class Client 
{

	public static void main(String[] args) 
	{
		HomeContext homeContext = new HomeContext();
		
		
		homeContext.setState(new FreeState());
		
		homeContext.setState(new ChecedState());
	}

}
