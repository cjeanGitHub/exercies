package com.cjean.daliytest.设计模式.创建者模式.工厂模式.factorymethod;

public class BenziFactory implements CarFactory{

	@Override
	public Car creatCar() {
		return new Benzi();
	}

}
