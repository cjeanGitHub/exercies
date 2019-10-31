package com.cjean.daliytest.设计模式.结构型模式.proxy.staticproxy;

/**
 * 测试静态代理模式
 * 这个是外部环境  所以不需要 直接对接角色  只要找代理角色就好
 * @author Cjean
 *
 */
public class Client {
	public static void main(String[] args) {
		//生成 代理角色
		new ProxyModel(new TrueModel()).Response();
	}

}
