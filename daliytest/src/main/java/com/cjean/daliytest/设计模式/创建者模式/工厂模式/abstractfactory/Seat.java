package com.cjean.daliytest.���ģʽ.������ģʽ.����ģʽ.abstractfactory;

public interface Seat {
	void message();
}
class RichSeat implements Seat{

	@Override
	public void message() {
		System.out.println("RichSeat->����͸��");
	}
}
class LowSeat implements Seat{

	@Override
	public void message() {
		System.out.println("LowSeat->�����");
	}
}
