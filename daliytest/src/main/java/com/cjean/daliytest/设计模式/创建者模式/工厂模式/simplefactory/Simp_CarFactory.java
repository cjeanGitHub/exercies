package com.cjean.daliytest.设计模式.创建者模式.工厂模式.simplefactory;

/**
 * 静态工厂   因为获取方法都是static修饰的静态的
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
