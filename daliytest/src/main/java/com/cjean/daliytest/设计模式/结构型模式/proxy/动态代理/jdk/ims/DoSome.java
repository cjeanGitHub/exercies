package com.cjean.daliytest.设计模式.结构型模式.proxy.动态代理.jdk.ims;

import com.cjean.daliytest.设计模式.结构型模式.proxy.动态代理.jdk.interfac.IDoSome;

public class DoSome implements IDoSome{

	@Override
	public String doFirst() {
		System.out.println("执行dofirst....");
		return "asdf";
	}

	@Override
	public void doSecond() {
		System.out.println("执行doSecond....");
	}
	
}
