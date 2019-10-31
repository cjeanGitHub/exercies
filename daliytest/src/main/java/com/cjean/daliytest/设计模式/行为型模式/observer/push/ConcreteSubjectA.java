package com.cjean.daliytest.设计模式.行为型模式.observer.push;

/**
 * 具体的对象   发生改变时 将改变值发送给所有对象
 * @author Cjean
 *
 */
public class ConcreteSubjectA extends Subject
{
	private int state;//目标状态

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		
		this.notifyAllObserver();//目标状态发生改变时，将状态改变通知所有注册的观察者
	}
	
	
}
