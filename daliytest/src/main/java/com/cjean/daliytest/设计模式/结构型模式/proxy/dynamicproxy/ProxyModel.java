package com.cjean.daliytest.设计模式.结构型模式.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理角色  需要对外提供  真实角色  以及  真实角色的功能
 * 	所以需要实现InvocationHandler的接口  以及 生成真实角色（由构造器进行实例化）
 * 
 * 	使用JDK自带的Proxy方法进行实现动态代理
 * 
 * 
 * InvocationHandler接口
 * 	InvocationHandler 是代理实例的调用处理程序 实现的接口。 
	每个代码实例都具有一个关联的调用处理程序。对代理实例调用方法时，将对方法调用进行编码并将其指派到它的调用处理程序的 invoke 方法。 
	
	
 * @author Cjean
 *
 */
public class ProxyModel implements InvocationHandler {

	private ProxyInter ProxyInter;
	
	public ProxyModel(ProxyInter ProxyInter) {
//		super();
		this.ProxyInter = ProxyInter;
	}

	/**
	 * invoke
		Object invoke(Object proxy,
              Method method,
              Object[] args)
              throws Throwable在代理实例上处理方法调用并返回结果。在与方法关联的代理实例上调用方法时，将在调用处理程序上调用此方法。 

		参数：
		proxy - 在其上调用方法的代理实例
		method - 对应于在代理实例上调用的接口方法的 Method 实例。Method 对象的声明类将是在其中声明方法的接口，该接口可以是代理类赖以继承方法
		的代理接口的超接口。
		args - 包含传入代理实例上方法调用的参数值的对象数组，如果接口方法不使用参数，则为 null。
		基本类型的参数被包装在适当基本包装器类（如 java.lang.Integer 或 java.lang.Boolean）的实例中。 
		返回：
		从代理实例的方法调用返回的值。如果接口方法的声明返回类型是基本类型，则此方法返回的值一定是相应基本包装对象类的实例；
		否则，它一定是可分配到声明返回类型的类型。如果此方法返回的值为 null 并且接口方法的返回类型是基本类型，
		则代理实例上的方法调用将抛出 NullPointerException。否则，如果此方法返回的值与上述接口方法的声明返回类型不兼容，
		则代理实例上的方法调用将抛出 ClassCastException。 
		抛出： 
		Throwable - 从代理实例上的方法调用抛出的异常。该异常的类型必须可以分配到在接口方法的 
		throws 子句中声明的任一异常类型或未经检查的异常类型 java.lang.RuntimeException 或 java.lang.Error。
		如果此方法抛出经过检查的异常，该异常不可分配到在接口方法的 throws 子句中声明的任一异常类型，
		代理实例的方法调用将抛出包含此方法曾抛出的异常的 UndeclaredThrowableException。
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		/**
		 * 在外部所有代理的功能都会进入此处进行处理   
		 * 与此同时，作为代理对象 在代理真实功能之前、之后都可以进行独特的处理
		 * 
		 */
		// 在代理之前我要干啥呢  收钱吧！！ 
		Object rs = null;
		System.out.println("代理在哪？？");
		Object mes = method.invoke(ProxyInter, args);
		if(null != mes && !"".equals(mes)) {
			rs = mes;
			//我在代理 有返回值的  功能呢   ，没有返回值的方法不会走这里的
			System.out.println("我在代理功能呢");
		}
		System.out.println("代理完成");
		//代理完成的  数数有多少钱了
		return rs;
	}

	

}
