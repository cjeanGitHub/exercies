package com.cjean.daliytest.oop;

import com.cjean.daliytest.oop.Outer.StaticInner;

public class TestInnerClass {
	
	public static void test01(AA a) {
		a.aa();
	}
	
	public static void main(String[] args) {
		new TestInnerClass().InnerInnerClass();
		
		Outer.Inner inner = new Outer().new Inner();
		StaticInner staticInner = new StaticInner();
		TestInnerClass.test01(new AA() {

			public void aa() {
				System.out.println("// TODO Auto-generated method stub");
			}
		});
		
		
	}
	
	//方法内部类  一般只用一次的复杂需要一个雷进行辅助解决的业务  
	public void InnerInnerClass(){
		
			class InnerInner2Class{
				public void fun() {
					System.out.println("//  InnerInner2Class");
				}
			}
			new InnerInner2Class().fun();
			
	}

}


// 内部类
class Outer{
	private int age = 10;
	
	public void testOuter() {
		
	}
	
	class Inner{//成员内部类可以直接使用外部类属性
		
	}
	
	static class StaticInner{//静态成员内部类可以直接使用外部类属性
		StaticInner (){
			System.out.println("StaticInner");
		}
		
	}
	
}

interface AA{
	void aa();
}


