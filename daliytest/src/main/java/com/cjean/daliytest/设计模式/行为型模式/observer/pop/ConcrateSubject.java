package com.cjean.daliytest.���ģʽ.��Ϊ��ģʽ.observer.pop;

import java.util.Observable;
/**
 * Ŀ�����
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
