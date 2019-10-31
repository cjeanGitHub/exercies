package com.cjean.daliytest.设计模式.行为型模式.observer.push;
/**
 * 观察者接口 
 * 	提供改变目标状态值方法
 * @author Cjean
 *
 */
public interface Observer 
{
	void update(Subject obs);
	
}
