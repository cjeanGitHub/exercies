package com.cjean.daliytest.设计模式.创建者模式.单例模式;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 饿汉式单例  
 * 	私有属性以及构造器  只把对象向外暴露
 * @author Cjean
 *
 */
//通过io读写破解饿汉式到了模式 需要实现  implements Serializable  接口来实现读写功能
//implements Serializable  
public class SingletonDemo01{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2857572878017706543L;
	// 由于是单例模式  
	private static SingletonDemo01 instance = new SingletonDemo01();

	private SingletonDemo01() {
		// 如果 不为空就返回 运行时异常（避免反射造成的 单例破解）
		//说明：这样就避免通过反射来调用构造器来破解单例
		if(null != instance) {
			throw new RuntimeException();
		}
	}
	
	public static SingletonDemo01 getInstance() {
		return instance;
	}
	
	// 防止读取 对象类 进行序列化以及反序列化的方式进行 对象单例破解
	//说明：这个方法是基于回调的，反序列化时，如果定义了readResolve()则直接返回此方法指定的对象，而不需要在创建新的对象！
	public Object readResolve() throws ObjectStreamException{
		return instance;
	}
	

}
