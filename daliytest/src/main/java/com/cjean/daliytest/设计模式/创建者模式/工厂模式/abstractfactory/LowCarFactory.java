package com.cjean.daliytest.设计模式.创建者模式.工厂模式.abstractfactory;

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
