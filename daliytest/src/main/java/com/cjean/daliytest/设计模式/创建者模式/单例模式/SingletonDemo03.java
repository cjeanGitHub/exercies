package com.cjean.daliytest.设计模式.创建者模式.单例模式;

import java.io.Serializable;

/**
 * 双重检测锁模式   
 * 	线程安全  单例  
 * 		但是由于 JVM内部优化问题以及 底层模型的原因造成 执行顺序不确定的问题   不建议使用
	
 * 	私有属性以及构造器  只把对象向外暴露
 * 有点延迟加载 （懒加载），调用效率不高  线程安全
 * @author Cjean
 *
 */
public class SingletonDemo03 implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5574950688524446901L;
	// 由于是单例   常驻static 一个变量
	private static SingletonDemo03 instance;

	private SingletonDemo03() {
		
	}
	
	// 线程安全  但是导致  效率性能降低
	public static SingletonDemo03 getInstance() {
		if(null != instance) {
			return instance;
		}else {
			synchronized (SingletonDemo04.class) {
				instance = new SingletonDemo03();
				return instance;
			}
		}
	}

}
