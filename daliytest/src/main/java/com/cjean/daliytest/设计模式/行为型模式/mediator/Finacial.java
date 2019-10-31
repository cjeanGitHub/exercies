package com.cjean.daliytest.设计模式.行为型模式.mediator;

public class Finacial implements Department {
	
	private Mediator mediator;

	public Finacial(Mediator mediator) {
		super();
		this.mediator = mediator;
		mediator.register("Finacial", this);
	}

	@Override
	public void selfWork() {
		System.out.println("Finacial：好好数钱");
	}

	@Override
	public void outWork() {
		System.out.println("Finacial：需要资金");
		mediator.command("Market");
	}

}
