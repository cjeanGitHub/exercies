package com.cjean.daliytest.���ģʽ.��Ϊ��ģʽ.observer.pop;


public class Client {

	public static void main(String[] args) 
	{
		//Ŀ�����
		ConcrateSubject sub = new ConcrateSubject();
		
		// �۲��߶���
		ConcrateObserver ob1 = new ConcrateObserver();
		ConcrateObserver ob2 = new ConcrateObserver();
		ConcrateObserver ob3 = new ConcrateObserver();
		
		// ���۲��߶�����ӵ� Ŀ�������
		sub.addObserver(ob1);
		sub.addObserver(ob2);
		sub.addObserver(ob3);
		
		// Ŀ��������ı�
		sub.setState(333);
		
		System.out.println(ob1.getMyState());
		System.out.println(ob2.getMyState());
		System.out.println(ob3.getMyState());
		System.out.println("###################");
		
		
	}	

}
