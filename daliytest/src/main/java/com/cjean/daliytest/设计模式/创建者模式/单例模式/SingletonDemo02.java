package com.cjean.daliytest.设计模式.创建者模式.单例模式;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 懒汉式单例  
 * 	私有属性以及构造器  只把对象向外暴露
 * 有点延迟加载 （懒加载），调用效率不高  线程安全
 * @author Cjean
 *
 */
public class SingletonDemo02 implements Serializable{
	
	// 由于是单例   常驻static 一个变量
	private static SingletonDemo02 instance;

	private SingletonDemo02() {
		if(null != instance) {
			throw new RuntimeException();
		}
	}
	
	// 线程安全  但是导致  效率性能降低
	public static synchronized SingletonDemo02 getInstance() {
		if(null == instance) {
			instance = new SingletonDemo02();
		}
		return instance;
	}
	public Object readResolve() throws ObjectStreamException{
		return instance;
	}

}
