package com.cjean.daliytest.设计模式.创建者模式.工厂模式.factorymethod;

public class TestMethod {

	public static void main(String[] args) {
		Car audi = new AudiFactory().creatCar();
		Car byd = new BydFactory().creatCar();
		audi.type();
		byd.type();
		
		Car benzi = new BenziFactory().creatCar();
		benzi.type();
	}

}
