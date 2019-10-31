package com.cjean.daliytest.设计模式.结构型模式.proxy.动态代理.CGLB.proxy;

import java.lang.reflect.Method;

import com.cjean.daliytest.设计模式.结构型模式.proxy.动态代理.CGLB.ims.DoSome;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * cglb是基于没有接口的动态代理
 * 由于没有接口 所以需要自己书写动态代理类
 * 自己书写的代理类需要实现MethodInterceptor（方法拦截器）
 * ，并且需要重写 方法拦截器接口的方法
 * 
 * 由于cglb方式是用于没有实现接口的，所以需要在子类的基础上增强（另一种说法：由子类增强父类）
 * 
 * 
 */

public class MyCGLBProxy implements MethodInterceptor{
	private DoSome target;
//	private IDoSome target;

	public MyCGLBProxy(DoSome target) {
		super();
		this.target = target;
	}
	
	public MyCGLBProxy() {
		
	}
	//增强父类
	public DoSome MyCGLB() {
		Enhancer enhancer = new Enhancer();
		//指定父类 即目标量  开始增强父类
		enhancer.setSuperclass(DoSome.class);
//		enhancer.setSuperclass(IDoSome.class);
		//指定会掉函数
		enhancer.setCallback(this);
		
		return (DoSome)enhancer.create();
//		return (IDoSome)enhancer.create();
		
	}

	@Override
	public Object intercept(Object arg
			, Method method
			, Object[] obj
			, MethodProxy methodProxy) throws Throwable {
		Object invoke = method.invoke(target, obj);
		if (null != invoke) {
			((String)invoke).toUpperCase();
		}
		return invoke;
	}
	
}
