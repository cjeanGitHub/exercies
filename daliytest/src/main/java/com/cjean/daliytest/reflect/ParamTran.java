package com.cjean.daliytest.reflect;

import java.lang.reflect.Field;

/**
 *  ��Ŀ��˼  �Զ��� int 2����������ӡ���������ֵ��ͨ��һ������ʵ�ֱ���ֵ���ĵ�Ŀ��
 *  
 *  	����� ���������������޷��ﵽĿ�ĵģ����ǿ��Խ������������Ͱ�װ��Ϊ���Ӧ�İ�װ��������
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
		System.out.println("a:"+a+",B��"+b);
		ParamTran p = new ParamTran();
	//	p.tran(a, b);
		p.swapByInteger(a, b);
		System.out.println("a2:"+a+",B2��"+b);*/

	}
	
	static void getReflect() {
		try {
			Class clazz = Class.forName("com.cjean.daliytest.reflect.ParamTran");
			Field field = clazz.getDeclaredField("d");
			field.setAccessible(true);
			System.err.println(field.getType());
			// ���ص�   �ڻ�ȡ���������Ե�ǰ��  �Լ� ���䷽�� ��Ҫ����� object������ class ��ʵ���� �� clazz.newInstance������
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
		System.out.println("a1:"+a1+",B1��"+b1);
		
	}

}
