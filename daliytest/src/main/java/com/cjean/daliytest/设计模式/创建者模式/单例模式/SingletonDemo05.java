package com.cjean.daliytest.设计模式.创建者模式.单例模式;

/**
 * 枚举式  单例  
 * 	枚举本身就是单例的  并且自带防止 反射以及序列化 破解单例的能力
 * @author Cjean
 *
 */
public enum SingletonDemo05 {
	
	/**
	 * 
	 */
	Instance;
	
	// 并且可以增加 需要的方法
	public void singltonOperation() {
		System.out.println("enum SingletonDemo05 ");
	}

}
