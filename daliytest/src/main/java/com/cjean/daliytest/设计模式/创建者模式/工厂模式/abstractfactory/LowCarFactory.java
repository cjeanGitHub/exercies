package com.cjean.daliytest.���ģʽ.������ģʽ.����ģʽ.abstractfactory;

public class LowCarFactory implements CarFactory {

	@Override
	public Engine creatEngine() {
		
		return new LowEngine();
	}

	@Override
	public Seat creatSeat() {
		
		return new LowSeat();
	}

	@Override
	public Tyre creatTyre() {
		
		return new LowTyre();
	}

}
