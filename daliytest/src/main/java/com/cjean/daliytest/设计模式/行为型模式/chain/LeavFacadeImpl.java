package com.cjean.daliytest.设计模式.行为型模式.chain;

public class LeavFacadeImpl implements LeavFacade {
	private HandlerRequest handlerRequest;
	
	

	public LeavFacadeImpl(HandlerRequest handlerRequest) {
		super();
		this.handlerRequest = handlerRequest;
		Operation();
		Manager manager = new Manager("找一");
		Manager2 manager2 = new Manager2("找一2");
		Manager3 manager3 = new Manager3("找一3");
		manager.setNextLeader(manager2);
		manager2.setNextLeader(manager3);
		System.out.println("处理中");
		manager.handlerRequest(handlerRequest);
	}


	@Override
	public void Operation() {
		System.out.println("外观模式使用中、、、、");
	}
}
