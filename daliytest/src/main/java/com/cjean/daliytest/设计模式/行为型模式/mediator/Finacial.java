package com.cjean.daliytest.���ģʽ.��Ϊ��ģʽ.mediator;

public class Finacial implements Department {
	
	private Mediator mediator;

	public Finacial(Mediator mediator) {
		super();
		this.mediator = mediator;
		mediator.register("Finacial", this);
	}

	@Override
	public void selfWork() {
		System.out.println("Finacial���ú���Ǯ");
	}

	@Override
	public void outWork() {
		System.out.println("Finacial����Ҫ�ʽ�");
		mediator.command("Market");
	}

}
