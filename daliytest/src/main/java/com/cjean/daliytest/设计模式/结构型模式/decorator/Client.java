package com.cjean.daliytest.设计模式.结构型模式.decorator;

public class Client {
	public static void main(String[] args) {
		Car car = new Car();
		car.mes();
		System.out.println("#############");
		Drive waterCar = new WaterCar(car);
		waterCar.mes();

		System.out.println("#############");
		Drive flyCar = new FlyCar(waterCar);
		flyCar.mes();
	}
}
