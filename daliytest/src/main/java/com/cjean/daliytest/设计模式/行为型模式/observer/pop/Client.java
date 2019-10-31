package com.cjean.daliytest.设计模式.行为型模式.observer.pop;


public class Client {

	public static void main(String[] args) 
	{
		//目标对象
		ConcrateSubject sub = new ConcrateSubject();
		
		// 观察者对象
		ConcrateObserver ob1 = new ConcrateObserver();
		ConcrateObserver ob2 = new ConcrateObserver();
		ConcrateObserver ob3 = new ConcrateObserver();
		
		// 将观察者对象添加到 目标对象中
		sub.addObserver(ob1);
		sub.addObserver(ob2);
		sub.addObserver(ob3);
		
		// 目标对象发生改变
		sub.setState(333);
		
		System.out.println(ob1.getMyState());
		System.out.println(ob2.getMyState());
		System.out.println(ob3.getMyState());
		System.out.println("###################");
		
		
	}	

}
