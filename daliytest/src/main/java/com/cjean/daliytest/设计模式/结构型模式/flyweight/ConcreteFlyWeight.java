package com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.flyweight;
/**
 * �ڲ�״̬�����干�е����� 
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
		System.out.println("X,Y����"+unSharedConcreteFlyWeight.getX()+"--"+unSharedConcreteFlyWeight.getY()+"�������ӵ���ɫ�ǣ�"+color);
	}
}
