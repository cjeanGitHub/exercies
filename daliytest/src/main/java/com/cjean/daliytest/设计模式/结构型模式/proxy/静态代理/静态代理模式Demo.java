package com.cjean.daliytest.设计模式.结构型模式.proxy.静态代理;

/**
 *静态代理 模式 （继承（extends）、聚合（implements））  3部分
 * 
 * 1.代理接口（增强后的对象）
 * 2.真实角色（被增强的对象）
 * 3.代理角色
 * 
 * @author Cjean
 *
 */
public class 静态代理模式Demo {
	public static void main(String[] args) {
		
		new MarryCompany(new You()).happyMarry();
	}
}
//代理接口
interface HappyMarry{
	void happyMarry();
}
//真实角色
class You implements HappyMarry{
	public void happyMarry() {
		System.out.println("今天你结婚！！");
	}
}

//代理角色
class MarryCompany implements HappyMarry{
	private You you;

	public MarryCompany(You you) {
		super();
		this.you = you;
	}
	public MarryCompany() {
		
		// TODO Auto-generated constructor stub
	}
	public void happyMarry() {
		you.happyMarry();
		after();
	}
	
	void after() {
		System.out.println("代理公司很棒。。。");
	}
	
}


