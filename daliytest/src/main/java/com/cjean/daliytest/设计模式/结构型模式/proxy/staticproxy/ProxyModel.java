package com.cjean.daliytest.设计模式.结构型模式.proxy.staticproxy;

/**
 * 代理角色  需要对外提供  真实角色  以及  真实角色的功能
 * 	所以需要实现功能的接口  以及 生成真实角色（由构造器进行实例化）
 * @author Cjean
 *
 */
public class ProxyModel implements ProxyInter {

	private TrueModel trueModel;
	
	public ProxyModel(TrueModel trueModel) {
//		super();
		this.trueModel = trueModel;
	}

	@Override
	public void Response() {
		//....代理角色完成
		System.out.println("找我实现啥功能的？？");
		//....代理角色完成
		
		//这个功能只有真实角色才能完成
		trueModel.Response();
		
		//....代理角色完成
		System.out.println("你看这个功能满意吗？？？");
		//....代理角色完成
	}
	

}
