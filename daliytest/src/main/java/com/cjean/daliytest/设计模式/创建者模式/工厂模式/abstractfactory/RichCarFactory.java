package com.cjean.daliytest.���ģʽ.������ģʽ.����ģʽ.abstractfactory;

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
