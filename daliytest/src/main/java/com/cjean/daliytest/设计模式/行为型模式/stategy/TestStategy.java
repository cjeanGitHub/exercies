package com.cjean.daliytest.设计模式.行为型模式.stategy;
/**
 *   这是在开发情况中对不同条件进行if判断进行区别不同的算法
 *   	在往后的维护中，不符合设计原则中的开闭原则  ,并且代码逻辑特别长
 *   		此宗情况可以施行  设计模式中的策略模式（stategy）
 * @author Cjean
 *
 */
public class TestStategy {
	public double getPeice(String type, double price) {
		if ("普通客户小批量".equals(type)) {
			return price;
		} else if ("普通客户大批量".equals(type)) {
			return (price*0.9);
		}else if ("老客户大批量".equals(type)) {
			return (price*0.8);
		}else if ("老客户小批量".equals(type)) {
			return (price*0.85);
		}
		
		return price;
	}
}
