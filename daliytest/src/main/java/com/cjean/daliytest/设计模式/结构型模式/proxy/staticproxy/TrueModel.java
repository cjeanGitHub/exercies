package com.cjean.daliytest.设计模式.结构型模式.proxy.staticproxy;
/**
 * 真是角色  提供真实角色的功能
 * 	如周杰伦 提供唱歌功能
 * @author Cjean
 *
 */
public class TrueModel implements ProxyInter{
	
	@Override
	public void Response() {
		System.out.println("提供真实角色 唱歌了");		
	}
	 		

}
