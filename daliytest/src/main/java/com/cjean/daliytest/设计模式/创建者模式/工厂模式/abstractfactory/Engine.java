package com.cjean.daliytest.���ģʽ.������ģʽ.����ģʽ.abstractfactory;

public interface Engine {
	void message();
}
class RichEngine implements Engine{

	@Override
	public void message() {
		System.out.println("RichEngine->ת�Ŀ�");
	}
	
}
class LowEngine implements Engine{

	@Override
	public void message() {
		System.out.println("LowEngine->ת����");
	}
	
}