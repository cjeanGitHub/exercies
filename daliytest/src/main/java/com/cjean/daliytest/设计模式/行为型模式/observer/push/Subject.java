package com.cjean.daliytest.设计模式.行为型模式.observer.push;

import java.util.ArrayList;
import java.util.List;
/**
 * 对象容器  负责将摸一个对象的改变   发送给所有对象
 * @author Cjean
 *
 */
public class Subject 
{
	//存放所有订阅观察者
	protected List<Observer> list = new ArrayList<Observer>();

	//注册方法
	public void registObserver(Observer obs) 
	{
		list.add(obs);
	}
	
	//注销方法
	public void removeObserver(Observer obs) 
	{
		list.remove(obs);
	}
	
	//状态内容通知
	public void notifyAllObserver() 
	{
		for (Observer observer : list) {
			observer.update(this);
		}
	}
	
}
