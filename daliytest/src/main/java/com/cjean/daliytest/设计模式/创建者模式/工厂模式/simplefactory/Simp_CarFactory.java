package com.cjean.daliytest.���ģʽ.������ģʽ.����ģʽ.simplefactory;

/**
 * ��̬����   ��Ϊ��ȡ��������static���εľ�̬��
 * 
 */
public class Simp_CarFactory {
	private static String type;
	
	public Simp_CarFactory() {
		super();
	}
	public Simp_CarFactory(String carType) {
		super();
		type = carType;
	}
	public static Simp_Car getByd() {
		return new Simp_Byd();
	}
	public static Simp_Car getAudi() {
		return new Simp_Audi();
	}
	
	public static Simp_Car getCar(String carType) {
		if("audi".equals(carType)) {
			return new Simp_Audi();
		}else if("byd".equals(carType)) {
			return new Simp_Byd();
		}else{
			return null;
		}
		
	}
	
	
	
	

}
