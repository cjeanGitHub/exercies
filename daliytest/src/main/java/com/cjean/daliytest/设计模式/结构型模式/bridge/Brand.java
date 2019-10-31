package com.cjean.daliytest.设计模式.结构型模式.bridge;

public interface Brand {
	void sale();
}
class LenovoBrand implements Brand{
	@Override
	public void sale() {
		System.out.println("销售联想牌");
	}
}
class DellBrand implements Brand{
	@Override
	public void sale() {
		System.out.println("销售DellBrand牌");
	}
}
class ShenzhouBrand implements Brand{
	@Override
	public void sale() {
		System.out.println("销售ShenzhouBrand牌");
	}
}