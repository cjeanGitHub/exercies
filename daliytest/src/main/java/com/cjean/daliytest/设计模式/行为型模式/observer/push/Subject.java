package com.cjean.daliytest.���ģʽ.��Ϊ��ģʽ.observer.push;

import java.util.ArrayList;
import java.util.List;
/**
 * ��������  ������һ������ĸı�   ���͸����ж���
 * @author Cjean
 *
 */
public class Subject 
{
	//������ж��Ĺ۲���
	protected List<Observer> list = new ArrayList<Observer>();

	//ע�᷽��
	public void registObserver(Observer obs) 
	{
		list.add(obs);
	}
	
	//ע������
	public void removeObserver(Observer obs) 
	{
		list.remove(obs);
	}
	
	//״̬����֪ͨ
	public void notifyAllObserver() 
	{
		for (Observer observer : list) {
			observer.update(this);
		}
	}
	
}
