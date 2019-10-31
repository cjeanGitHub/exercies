package com.cjean.daliytest.设计模式.创建者模式.工厂模式.abstractfactory;

public interface Tyre {
	void message();
}
class RichTyre implements Tyre{

	@Override
	public void message() {
		System.out.println("RichTyre-》磨损慢");
	}
}
class LowTyre implements Tyre{

	@Override
	public void message() {
		System.out.println("LowTyre->磨损块");
	}
}