package com.cjean.daliytest.设计模式.行为型模式.mediator;

public class Market implements Department {
	
	private Mediator mediator;

	public Market(Mediator mediator) {
		super();
		this.mediator = mediator;
		mediator.register("Market", this);
	}

	@Override
	public void selfWork() {
		System.out.println("Market：好好开发市场");
	}

	@Override
	public void outWork() {
		System.out.println("Market：需要支持");
		mediator.command("Finacial");
	}

}
