package com.cjean.daliytest.���ģʽ.������ģʽ.����ģʽ.factorymethod;

public class AudiFactory implements CarFactory {
	@Override
	public Car creatCar() {
		return new Audi();
	}

}
