package com.cjean.daliytest.设计模式.结构型模式.proxy.staticproxy;

/**
 * 代理接口  针对功能的 
 * 	需要的什么功能，这个功能是真实角色 和 代理角色都需要的  
 * 	所以 真实角色 以及 代理角色 都需要进行   实现的
 * 	
 * @author Cjean
 *
 */
public interface ProxyInter {
	void Response();
}
