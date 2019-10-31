package com.cjean.daliytest.设计模式.创建者模式.建造者模式;

public class Client {

	public static void main(String[] args) {
		AirShipBuilder sxtAirShipBuilder = new SxtAirShipBuilder();
		AirShipDirecter sxtAirShipDirecter = new SxtAirShipDirecter(sxtAirShipBuilder);
		AirShip directerAirShip = sxtAirShipDirecter.DirecterAirShip();
		
		System.out.println(directerAirShip.getEngine().getEname());;
	}

}
