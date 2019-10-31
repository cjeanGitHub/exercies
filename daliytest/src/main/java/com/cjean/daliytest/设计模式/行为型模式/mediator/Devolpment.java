package com.cjean.daliytest.���ģʽ.��Ϊ��ģʽ.mediator;

public class Devolpment implements Department {
	
	private Mediator mediator;

	public Devolpment(Mediator mediator) {
		super();
		this.mediator = mediator;
		mediator.register("Devolpment", this);
	}

	@Override
	public void selfWork() {
		System.out.println("Devolpment���úÿ���");
	}

	@Override
	public void outWork() {
		System.out.println("Devolpment����Ҫ֧��");
		mediator.command("Finacial");
	}

}
