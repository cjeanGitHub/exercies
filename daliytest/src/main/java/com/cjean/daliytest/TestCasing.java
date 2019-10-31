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
		// 测试内部类   可以直接使用外部类的属性、方法
	}

}

class Animal{
	public void sayHi() {
		System.out.println("父辈");
	}
}

class Dog extends Animal{
	public void sayHi() {
		System.out.println("钩子");
	}
}
class Cat extends Animal{
	public void sayHi() {
		System.out.println("猫咪");
	}
}