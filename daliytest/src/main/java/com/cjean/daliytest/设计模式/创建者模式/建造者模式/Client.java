package com.cjean.daliytest.���ģʽ.������ģʽ.������ģʽ;

public class Client {

	public static void main(String[] args) {
		AirShipBuilder sxtAirShipBuilder = new SxtAirShipBuilder();
		AirShipDirecter sxtAirShipDirecter = new SxtAirShipDirecter(sxtAirShipBuilder);
		AirShip directerAirShip = sxtAirShipDirecter.DirecterAirShip();
		
		System.out.println(directerAirShip.getEngine().getEname());;
	}

}
