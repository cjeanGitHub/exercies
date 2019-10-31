package com.cjean.daliytest.设计模式.结构型模式.flyweight;

public class UnSharedConcreteFlyWeight {
	protected int x;
	protected int y;
	/**
	 * @param x
	 * @param y
	 */
	public UnSharedConcreteFlyWeight(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
}
