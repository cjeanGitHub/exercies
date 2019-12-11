package com.cjean.spring.msb_cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CGLibFactory implements MethodInterceptor {

	
	
	private Object target;
	
	
	public CGLibFactory () {
		super();
	}
	public CGLibFactory(Object taObject) {
		super();
		this.target = taObject;
	}
	

	public Object createXXOO() {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(Girl.class);
		enhancer.setCallback(this);
		return enhancer.create();
	}
	
	
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

		System.out.println("qian");
		method.invoke(target, args);
		System.out.println("hou");
		return null;
	}



}
