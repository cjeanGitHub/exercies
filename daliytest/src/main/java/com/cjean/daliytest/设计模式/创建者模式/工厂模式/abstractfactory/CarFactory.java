package com.cjean.daliytest.设计模式.创建者模式.工厂模式.abstractfactory;

public interface CarFactory {
	Engine creatEngine();
	Seat creatSeat();
	Tyre creatTyre();
}

