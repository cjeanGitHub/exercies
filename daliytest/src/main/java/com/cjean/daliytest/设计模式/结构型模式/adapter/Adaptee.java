package com.cjean.daliytest.设计模式.结构型模式.adapter;
/**
 * 被适配器  适配器者、  拥有功能的类
 * @author chu_c
 *
 */
public class Adaptee {
	void request() {
		System.out.println("提供打字的功能");
	}
}
