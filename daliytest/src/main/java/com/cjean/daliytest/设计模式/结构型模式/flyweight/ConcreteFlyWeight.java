package com.cjean.daliytest.设计模式.结构型模式.flyweight;
/**
 * 内部状态：定义共有的特性 
 * @author Cjean
 *
 */
public class ConcreteFlyWeight {
	private String color;
	private UnSharedConcreteFlyWeight unSharedConcreteFlyWeight;
	/**
	 * @param color
	 */
	public ConcreteFlyWeight(String color) {
		super();
		this.color = color;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public UnSharedConcreteFlyWeight getUnSharedConcreteFlyWeight() {
		return unSharedConcreteFlyWeight;
	}
	public void setUnSharedConcreteFlyWeight(UnSharedConcreteFlyWeight unSharedConcreteFlyWeight) {
		this.unSharedConcreteFlyWeight = unSharedConcreteFlyWeight;
	}
	public void Operation() {
		System.out.println("X,Y处《"+unSharedConcreteFlyWeight.getX()+"--"+unSharedConcreteFlyWeight.getY()+"》的棋子的颜色是："+color);
	}
}
