package com.cjean.daliytest.���ģʽ.������ģʽ.����ģʽ.factorymethod;

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
