package com.cjean.daliytest.设计模式.创建者模式.工厂模式.abstractfactory;

public class RichCarFactory implements CarFactory {

	@Override
	public Engine creatEngine() {
		return new RichEngine();
	}

	@Override
	public Seat creatSeat() {
		return new RichSeat();
	}

	@Override
	public Tyre creatTyre() {
		return new RichTyre();
	}
	
}
