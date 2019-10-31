package com.cjean.daliytest.设计模式.行为型模式.observer.pop;

import java.util.Observable;
/**
 * 目标对象
 * @author Cjean
 *
 */
public class ConcrateSubject extends Observable {
	
	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		
		setChanged();
		
		notifyObservers(state);
	}
	
	

}
