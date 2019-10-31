package com.cjean.daliytest.设计模式.结构型模式.proxy.动态代理.jdk.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import com.cjean.daliytest.设计模式.结构型模式.proxy.动态代理.jdk.ims.DoSome;
import com.cjean.daliytest.设计模式.结构型模式.proxy.动态代理.jdk.interfac.IDoSome;
import com.cjean.daliytest.设计模式.结构型模式.proxy.动态代理.jdk.proxy.DoSomeProxy;

public class test{
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		Class c = Class.forName("com.cjean.daliytest.设计模式.结构型模式.proxy.动态代理.jdk.ims.DoSome");
		IDoSome ser1 = (DoSome)(c.newInstance());
		String re1 = ser1.doFirst();
		System.out.println("-->"+re1);

		System.out.println("-->-----------------");
		IDoSome ser = new DoSome();
		String re = ser.doFirst();
		System.out.println("-->"+re);
		/*//静态代理  本质是学习过的实现接口或者继承class的形式 ，但是静态代理容易出现类爆炸的问题
		IDoSome ser = new DoSome();
		String re = ser.doFirst();
		System.out.println("-->"+re);
		IDoSome serproxy = new DoSomeProxy(ser);
		String reProxy = serproxy.doFirst();
		System.out.println("-->"+reProxy);*/
		
		// 动态代理
		
		IDoSome dynamicSer = (IDoSome)Proxy.newProxyInstance(
				//加载代理对象（类）
				ser.getClass().getClassLoader()
				//加载代理类的接口
				, ser.getClass().getInterfaces()
				// 使用匿名内部类 来进行动态加载 具体 实现类的方法
				, new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						String mes = null;
						Object rs = method.invoke(ser, args);
						if(null != rs) {
							mes = re.toString().toUpperCase();
						}
						return mes;
					}
				});
		String mes = dynamicSer.doFirst();
		System.out.println(mes);
		dynamicSer.doSecond();
		

	}
	
}
