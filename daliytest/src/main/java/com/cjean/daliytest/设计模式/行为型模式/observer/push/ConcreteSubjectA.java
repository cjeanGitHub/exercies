package com.cjean.daliytest.���ģʽ.��Ϊ��ģʽ.observer.push;

/**
 * ����Ķ���   �����ı�ʱ ���ı�ֵ���͸����ж���
 * @author Cjean
 *
 */
public class ConcreteSubjectA extends Subject
{
	private int state;//Ŀ��״̬

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		
		this.notifyAllObserver();//Ŀ��״̬�����ı�ʱ����״̬�ı�֪ͨ����ע��Ĺ۲���
	}
	
	
}
