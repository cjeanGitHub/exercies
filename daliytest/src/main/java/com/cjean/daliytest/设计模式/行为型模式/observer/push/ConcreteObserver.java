package com.cjean.daliytest.设计模式.行为型模式.observer.push;

/**
 * 具体的观察者对象  更新自己的状态值
 * @author Cjean
 *
 */
public class ConcreteObserver implements Observer
{
	private int myState;

	@Override
	public void update(Subject obj) {
		
		myState = ((ConcreteSubjectA) obj).getState();
	}

	public int getMyState() {
		return myState;
	}

	public void setMyState(int myState) {
		this.myState = myState;
	}
	
	
}
