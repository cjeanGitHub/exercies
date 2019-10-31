package com.cjean.daliytest.设计模式.结构型模式.proxy.动态代理.jdk.proxy;

import com.cjean.daliytest.设计模式.结构型模式.proxy.动态代理.jdk.ims.DoSome;
import com.cjean.daliytest.设计模式.结构型模式.proxy.动态代理.jdk.interfac.IDoSome;

public class DoSomeProxy implements IDoSome{
	private IDoSome target;

	public DoSomeProxy(IDoSome target) {
//		super();
		this.target = target;
	}

	@Override
	public String doFirst() {
		String mes = null;
		String rs = target.doFirst();
		if (null != rs) {
			mes = rs.toUpperCase();
		}
		return mes;
	}

	@Override
	public void doSecond() {
		System.out.println("执行 DoSomeProxy -的-doSecond....");
	}
	
}
