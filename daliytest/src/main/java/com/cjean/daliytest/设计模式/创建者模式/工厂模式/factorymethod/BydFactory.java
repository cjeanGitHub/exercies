package com.cjean.daliytest.���ģʽ.������ģʽ.����ģʽ.factorymethod;

public class BydFactory implements CarFactory {
	@Override
	public Car creatCar() {
		return new Byd();
	}

}
