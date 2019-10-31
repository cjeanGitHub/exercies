package com.cjean.daliytest.设计模式.结构型模式.proxy.动态代理.CGLB.test;

import com.cjean.daliytest.设计模式.结构型模式.proxy.动态代理.CGLB.ims.DoSome;
import com.cjean.daliytest.设计模式.结构型模式.proxy.动态代理.CGLB.proxy.MyCGLBProxy;

public class test{
	public static void main(String[] args) {
		
		
		
		DoSome ser = new DoSome();
//		IDoSome ser = new DoSome();
		String re = ser.doFirst();
		System.out.println("-->"+re);
		// 基于CGLB的动态代理
		DoSome cglbSer = new MyCGLBProxy(ser).MyCGLB();
		
		String mes = cglbSer.doFirst();
		System.out.println(mes);
		cglbSer.doSecond();
		

	}
	
}
