package com.cjean.daliytest.设计模式.行为型模式.mediator;

public class Devolpment implements Department {
	
	private Mediator mediator;

	public Devolpment(Mediator mediator) {
		super();
		this.mediator = mediator;
		mediator.register("Devolpment", this);
	}

	@Override
	public void selfWork() {
		System.out.println("Devolpment：好好开发");
	}

	@Override
	public void outWork() {
		System.out.println("Devolpment：需要支持");
		mediator.command("Finacial");
	}

}
