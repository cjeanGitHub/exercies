package com.cjean.daliytest.设计模式.行为型模式.stategy;

/**
 * 负责和具体的策略交互
 * 这样的话，具体的算法和直接的客户端调用分离了，是的算法可以独立于客户端的变化
 * 如果使用spring的依赖注入功能，还可以通过配置文件，动态注入不同策略对象，动态的切换不同的算法
 * @author Cjean
 *
 */
public class Context {
	private Stategy stategy;//当前采用的算法对象

	//可以通过构造器注入
	public Context(Stategy stategy) {
		super();
		this.stategy = stategy;
	}
	
	
	
	public Stategy getStategy() {
		return stategy;
	}


//通过set方法注入
	public void setStategy(Stategy stategy) {
		this.stategy = stategy;
	}



	public void getPrice(double price) {
		System.out.println("Context注入");
		System.out.println(stategy.getPrice(price));
	}
}
