package com.cjean.daliytest.设计模式.创建者模式.工厂模式.abstractfactory;

public class Client {
	public static void main(String[] args) {
		CarFactory c = new RichCarFactory();
		Engine richEngine = c.creatEngine();
		richEngine.message();
	}
}
