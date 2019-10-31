package com.cjean.daliytest.设计模式.创建者模式.工厂模式.abstractfactory;

public interface Engine {
	void message();
}
class RichEngine implements Engine{

	@Override
	public void message() {
		System.out.println("RichEngine->转的块");
	}
	
}
class LowEngine implements Engine{

	@Override
	public void message() {
		System.out.println("LowEngine->转的慢");
	}
	
}