package com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.bridge;

public interface Brand {
	void sale();
}
class LenovoBrand implements Brand{
	@Override
	public void sale() {
		System.out.println("����������");
	}
}
class DellBrand implements Brand{
	@Override
	public void sale() {
		System.out.println("����DellBrand��");
	}
}
class ShenzhouBrand implements Brand{
	@Override
	public void sale() {
		System.out.println("����ShenzhouBrand��");
	}
}