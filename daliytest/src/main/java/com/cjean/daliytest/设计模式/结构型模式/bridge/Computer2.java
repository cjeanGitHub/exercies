package com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.bridge;

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
		System.out.println("����̨ʽ����");
	}
}
class Laptoptop extends Computer2{

	public Laptoptop(Brand brand) {
		super(brand);
	}
	
	public void sale() {
		brand.sale();
		System.out.println("���۱ʼǱ���");
	}
}
