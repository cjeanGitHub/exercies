package com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.decorator;

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
