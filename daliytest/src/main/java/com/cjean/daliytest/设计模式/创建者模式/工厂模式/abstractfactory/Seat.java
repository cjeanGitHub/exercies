package com.cjean.daliytest.设计模式.创建者模式.工厂模式.abstractfactory;

public interface Seat {
	void message();
}
class RichSeat implements Seat{

	@Override
	public void message() {
		System.out.println("RichSeat->超级透气");
	}
}
class LowSeat implements Seat{

	@Override
	public void message() {
		System.out.println("LowSeat->捂出汗");
	}
}
