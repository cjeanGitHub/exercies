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
	
	//�����ڲ���  һ��ֻ��һ�εĸ�����Ҫһ���׽��и��������ҵ��  
	public void InnerInnerClass(){
		
			class InnerInner2Class{
				public void fun() {
					System.out.println("//  InnerInner2Class");
				}
			}
			new InnerInner2Class().fun();
			
	}

}


// �ڲ���
class Outer{
	private int age = 10;
	
	public void testOuter() {
		
	}
	
	class Inner{//��Ա�ڲ������ֱ��ʹ���ⲿ������
		
	}
	
	static class StaticInner{//��̬��Ա�ڲ������ֱ��ʹ���ⲿ������
		StaticInner (){
			System.out.println("StaticInner");
		}
		
	}
	
}

interface AA{
	void aa();
}


