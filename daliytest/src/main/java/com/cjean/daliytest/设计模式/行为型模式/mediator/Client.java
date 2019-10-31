package com.cjean.daliytest.设计模式.行为型模式.mediator;

public class Client {

	public static void main(String[] args) {
		Mediator mediator = new Present();
		
		Devolpment devolpment = new Devolpment(mediator);
		Finacial finacial = new Finacial(mediator);
		Market market = new Market(mediator);
		
		market.selfWork();
		market.outWork();
	}

}
