package com.cjean.daliytest.设计模式.结构型模式.bridge;

public class Computer2 {
	protected Brand brand;

	public Computer2(Brand brand) {
		super();
		this.brand = brand;
	}
	public void sale() {
		brand.sale();
	}
	
}
class Desktop extends Computer2{

	public Desktop(Brand brand) {
		super(brand);
	}
	
	public void sale() {
		brand.sale();
		System.out.println("销售台式机啊");
	}
}
class Laptoptop extends Computer2{

	public Laptoptop(Brand brand) {
		super(brand);
	}
	
	public void sale() {
		brand.sale();
		System.out.println("销售笔记本啊");
	}
}
