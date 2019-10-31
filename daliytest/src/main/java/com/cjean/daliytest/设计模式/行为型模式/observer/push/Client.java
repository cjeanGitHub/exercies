package com.cjean.daliytest.设计模式.行为型模式.observer.push;

public class Client {

	public static void main(String[] args) 
	{
		//一个目标对象
		ConcreteSubjectA concreteSubjectA1 = new ConcreteSubjectA();
		
		//多个观察者
		ConcreteObserver ob1 = new ConcreteObserver();
		ConcreteObserver ob2 = new ConcreteObserver();
		ConcreteObserver ob3 = new ConcreteObserver();
		
		//将观察者放进对象管理容器中
		concreteSubjectA1.registObserver(ob1);
		concreteSubjectA1.registObserver(ob2);
		concreteSubjectA1.registObserver(ob3);
		
		//一个目标的状态、内容发生改变
		concreteSubjectA1.setState(2222);
		
		//打印所有观察者的状态
		System.out.println(ob1.getMyState());
		System.out.println(ob2.getMyState());
		System.out.println(ob3.getMyState());
		System.out.println("*******************");
	}

}
