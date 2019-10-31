package com.cjean.daliytest.设计模式.行为型模式.observer.pop;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者对象
 * @author Cjean
 *
 */
public class ConcrateObserver implements Observer {
	
	private int myState;

	@Override
	public void update(Observable o, Object arg) {
		myState = ((ConcrateSubject)o).getState();
	}

	public int getMyState() {
		return myState;
	}

	public void setMyState(int myState) {
		this.myState = myState;
	}
	
	

}
