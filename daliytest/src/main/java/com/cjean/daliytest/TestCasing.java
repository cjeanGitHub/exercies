package com.cjean.daliytest;

public class TestCasing {

	public static void main(String[] args) {

		Animal a = new Animal();
		a.sayHi();
		Dog d = new Dog();
		d.sayHi();
		Animal d1 = new Dog();
		d1.sayHi();
		
	}
	
	class Test{
		// �����ڲ���   ����ֱ��ʹ���ⲿ������ԡ�����
	}

}

class Animal{
	public void sayHi() {
		System.out.println("����");
	}
}

class Dog extends Animal{
	public void sayHi() {
		System.out.println("����");
	}
}
class Cat extends Animal{
	public void sayHi() {
		System.out.println("è��");
	}
}