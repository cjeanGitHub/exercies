package com.cjean.daliytest.���ģʽ.��Ϊ��ģʽ.chain;

public class LeavFacadeImpl implements LeavFacade {
	private HandlerRequest handlerRequest;
	
	

	public LeavFacadeImpl(HandlerRequest handlerRequest) {
		super();
		this.handlerRequest = handlerRequest;
		Operation();
		Manager manager = new Manager("��һ");
		Manager2 manager2 = new Manager2("��һ2");
		Manager3 manager3 = new Manager3("��һ3");
		manager.setNextLeader(manager2);
		manager2.setNextLeader(manager3);
		System.out.println("������");
		manager.handlerRequest(handlerRequest);
	}


	@Override
	public void Operation() {
		System.out.println("���ģʽʹ���С�������");
	}
}
