package com.cjean.daliytest.���ģʽ.��Ϊ��ģʽ.state;

public class Client 
{

	public static void main(String[] args) 
	{
		HomeContext homeContext = new HomeContext();
		
		
		homeContext.setState(new FreeState());
		
		homeContext.setState(new ChecedState());
	}

}
