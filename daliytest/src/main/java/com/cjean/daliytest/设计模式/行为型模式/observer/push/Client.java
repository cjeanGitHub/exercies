package com.cjean.daliytest.���ģʽ.��Ϊ��ģʽ.observer.push;

public class Client {

	public static void main(String[] args) 
	{
		//һ��Ŀ�����
		ConcreteSubjectA concreteSubjectA1 = new ConcreteSubjectA();
		
		//����۲���
		ConcreteObserver ob1 = new ConcreteObserver();
		ConcreteObserver ob2 = new ConcreteObserver();
		ConcreteObserver ob3 = new ConcreteObserver();
		
		//���۲��߷Ž��������������
		concreteSubjectA1.registObserver(ob1);
		concreteSubjectA1.registObserver(ob2);
		concreteSubjectA1.registObserver(ob3);
		
		//һ��Ŀ���״̬�����ݷ����ı�
		concreteSubjectA1.setState(2222);
		
		//��ӡ���й۲��ߵ�״̬
		System.out.println(ob1.getMyState());
		System.out.println(ob2.getMyState());
		System.out.println(ob3.getMyState());
		System.out.println("*******************");
	}

}
