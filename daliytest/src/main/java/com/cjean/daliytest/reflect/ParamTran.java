package com.cjean.daliytest.reflect;

import java.lang.reflect.Field;

/**
 *  题目意思  自定义 int 2个变量，打印输出变量的值；通过一个方法实现变量值更改的目的
 *  
 *  	解决： 基本数据类型是无法达到目的的，但是可以将基本数据类型包装称为相对应的包装类进行输出
 * @author chu_c
 *
 */

public class ParamTran {
	private int c = 0;
	
	private String d = "aa";
	
	public static void main(String[] args) {
		
		getReflect();
/*		Integer a = 1;
//		int a = 1;
		int b = 2;
		System.out.println("a:"+a+",B："+b);
		ParamTran p = new ParamTran();
	//	p.tran(a, b);
		p.swapByInteger(a, b);
		System.out.println("a2:"+a+",B2："+b);*/

	}
	
	static void getReflect() {
		try {
			Class clazz = Class.forName("com.cjean.daliytest.reflect.ParamTran");
			Field field = clazz.getDeclaredField("d");
			field.setAccessible(true);
			System.err.println(field.getType());
			// 很重点   在获取方法、属性的前提  以及 反射方法 需要传入的 object对象都是 class 的实例化 即 clazz.newInstance（）；
			Object clazzObj = clazz.newInstance();
			System.out.println(field.get(clazzObj));
			field.set(clazzObj, "hhh");
			System.out.println(field.get(clazzObj));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	void swapByInteger(Integer a,Integer b) {
		try {
			a = new Integer(a);
			Class aClass = a.getClass();
			Field afield = aClass.getDeclaredField("value");
			afield.setAccessible(true);
			afield.set(a, 333);
			System.err.println(afield.getType());
			System.out.println(a);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void tran(int a, int b) {
		int a1 = a+1;
		int b1 = b>>2;
		System.out.println("a1:"+a1+",B1："+b1);
		
	}

}
