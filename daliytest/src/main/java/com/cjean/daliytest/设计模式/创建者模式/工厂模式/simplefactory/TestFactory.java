package com.cjean.daliytest.���ģʽ.������ģʽ.����ģʽ.simplefactory;

public class TestFactory {
	
	public static void main(String[] args) {
		
		
		
		// ͨ�����ù����еľ�̬��������������
//		testSimpFactory();
		// �޹���ģʽ
	//	testNoFactory();
	}
	// ͨ�����ù����е�ʵ�ַ�������������
	public static void testSimpFactory() {
		
		//ͨ���������ȷ��������
		Simp_Car audi1 = Simp_CarFactory.getCar("audi");
		Simp_Car byd1 = Simp_CarFactory.getCar("byd");
		audi1.type();
		byd1.type();
		System.out.println("=====getCar=======");
		// ͨ�����ù����е�ʵ�ַ�������������
		Simp_Car audi = Simp_CarFactory.getAudi();
		Simp_Car byd = Simp_CarFactory.getByd();
		//===
		audi.type();
		byd.type();
	}
	// �޹���ģʽ
	public static void testNoFactory() {
		Simp_Car audi = new Simp_Audi();
		Simp_Car byd = new Simp_Byd();
		
		audi.type();
		byd.type();
		
	}
}
