package com.cjean.daliytest.���ģʽ.��Ϊ��ģʽ.observer.push;

/**
 * ����Ĺ۲��߶���  �����Լ���״ֵ̬
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
