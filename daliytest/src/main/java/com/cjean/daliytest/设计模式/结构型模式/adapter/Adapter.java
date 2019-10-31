package com.cjean.daliytest.设计模式.结构型模式.adapter;
/**
 * （类）适配器 不灵活
 * 
 *  	链接 被适配器 并且向 目标接口提供功能
 * @author chu_c
 *
 */
public class Adapter extends Adaptee implements Target {

	@Override
	public void HandlReq() {
		super.request();
	}
	
}
