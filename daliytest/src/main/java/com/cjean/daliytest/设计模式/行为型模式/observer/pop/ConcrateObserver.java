package com.cjean.daliytest.���ģʽ.��Ϊ��ģʽ.observer.pop;

import java.util.Observable;
import java.util.Observer;

/**
 * �۲��߶���
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
