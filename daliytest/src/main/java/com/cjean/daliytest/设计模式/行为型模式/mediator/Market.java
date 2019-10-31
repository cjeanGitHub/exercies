package com.cjean.daliytest.���ģʽ.��Ϊ��ģʽ.mediator;

public class Market implements Department {
	
	private Mediator mediator;

	public Market(Mediator mediator) {
		super();
		this.mediator = mediator;
		mediator.register("Market", this);
	}

	@Override
	public void selfWork() {
		System.out.println("Market���úÿ����г�");
	}

	@Override
	public void outWork() {
		System.out.println("Market����Ҫ֧��");
		mediator.command("Finacial");
	}

}
