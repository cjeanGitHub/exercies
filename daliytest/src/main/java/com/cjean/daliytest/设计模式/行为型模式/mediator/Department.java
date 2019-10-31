package com.cjean.daliytest.设计模式.行为型模式.mediator;

public interface Department {
	void selfWork();//处理自身业务
	void outWork();//处理通过中介者实现的业务
}
