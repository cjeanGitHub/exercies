package com.cjean.daliytest.���ģʽ.������ģʽ.����ģʽ.abstractfactory;

public class Client {
	public static void main(String[] args) {
		CarFactory c = new RichCarFactory();
		Engine richEngine = c.creatEngine();
		richEngine.message();
	}
}
