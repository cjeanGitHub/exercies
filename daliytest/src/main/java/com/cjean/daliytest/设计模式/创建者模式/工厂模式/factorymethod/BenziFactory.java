package com.cjean.daliytest.���ģʽ.������ģʽ.����ģʽ.factorymethod;

public class BenziFactory implements CarFactory{

	@Override
	public Car creatCar() {
		return new Benzi();
	}

}
