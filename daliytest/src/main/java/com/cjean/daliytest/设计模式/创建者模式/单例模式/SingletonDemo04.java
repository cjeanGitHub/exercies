package com.cjean.daliytest.设计模式.创建者模式.单例模式;

import java.io.Serializable;

/**
 * 静态内部类模式   
 * 	线程安全  单例  
 * 		线程
	
 * 	私有属性以及构造器  只把对象向外暴露
 * 有点延迟加载 （懒加载），调用效率高  线程安全
 * @author Cjean
 *
 */
public class SingletonDemo04 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SingletonDemo04() {
		
	}
	
	public static class SingletonDemo04Instance{
		// 由于是单例   常驻static 一个变量
		private static SingletonDemo04 instance = new SingletonDemo04();
	}
	
	// 线程安全  但是导致  效率性能降低
	public static SingletonDemo04 getInstance() {
		return SingletonDemo04.SingletonDemo04Instance.instance;
	}

}
