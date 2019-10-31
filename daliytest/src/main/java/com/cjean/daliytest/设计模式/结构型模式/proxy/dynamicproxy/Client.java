package com.cjean.daliytest.设计模式.结构型模式.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 测试  JDK 的动态代理模式
 * 这个是外部环境  所以不需要 直接对接角色  只要找代理角色就好
 * 
 * @author Cjean
 *
 */
public class Client {
	public static void main(String[] args) {
		/**
		 * 第二种
		 */
//		dynamicProxy02();
		/**
		 * 第1种
		 */
		dynamicProxy01();
	}
	
	static void dynamicProxy02() {
		/**
		 * 第二种
		 */
		// 生产真实功能接口引用   以及   真实对象
		ProxyInter trueModel = new TrueModel();
		ProxyInter newProxyInstance =(ProxyInter) Proxy.newProxyInstance(
				trueModel.getClass().getClassLoader()
				, trueModel.getClass().getInterfaces()
				, new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("::::::::::");
						Object re = null;
						Object mes = method.invoke(trueModel, args);
						if(null != mes && !"".equals(mes)) {
							System.out.println(":if:");
							re = mes;
						}
						return re;
					}
				});
		newProxyInstance.Response();
		System.out.println("***********");
		String mes = newProxyInstance.Up("iosdjgo");
		System.out.println("结果是：==="+mes);
		System.out.println("***********");
		
	}
	
	static void dynamicProxy01() {
		/**
		 * 弟一种
		 */
		// 生产真实功能接口引用   以及   真实对象
		ProxyInter trueModel = new TrueModel();
		// 生成代理对象  以及 传入  真实功能接口引用
		ProxyModel proxyModel = new ProxyModel(trueModel);
		// 利用Proxy方法进行对 代理方法的加载
		ProxyInter newProxyInstance = (ProxyInter) Proxy.newProxyInstance(
				//  加载器 去加载方法
				ClassLoader.getSystemClassLoader()
				// 加载 方法接口
				, new Class[] {ProxyInter.class}
				// 加载 实现InvocationHandler接口的代理对象   InvocationHandler
				, proxyModel);
		newProxyInstance.Response();
		System.out.println("**************");
		String rs = newProxyInstance.Up("qwert");
		System.out.println("result:***"+rs);
	}

}
