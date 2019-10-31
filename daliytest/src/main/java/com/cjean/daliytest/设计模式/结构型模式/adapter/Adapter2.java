package com.cjean.daliytest.设计模式.结构型模式.adapter;
/**
 * （对象）适配器 
 * 
 *  	链接 被适配器 并且向 目标接口提供功能
 *  
 *  
 * @author chu_c
 *
 */
public class Adapter2 implements Target {
	private Adaptee adaptee;

	public Adapter2(Adaptee adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public void HandlReq() {
		adaptee.request();
	}
	
}
