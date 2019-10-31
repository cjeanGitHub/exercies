package com.cjean.daliytest.设计模式.行为型模式.chain;

public class Client {

	public static void main(String[] args) {
		HandlerRequest handlerRequest1 = new HandlerRequest("小孔",8,"学车！！");
		HandlerRequest handlerRequest2 = new HandlerRequest("小孔",13,"学车！！");
		HandlerRequest handlerRequest3 = new HandlerRequest("小孔",35,"学车！！");
		HandlerRequest handlerRequest4 = new HandlerRequest("小孔",99,"学车！！");
		LeavFacade f1 = new LeavFacadeImpl(handlerRequest1);
		System.out.println("**************");
		LeavFacade f2 = new LeavFacadeImpl(handlerRequest2);
		System.out.println("**************");
		LeavFacade f3 = new LeavFacadeImpl(handlerRequest3);
		System.out.println("**************");
		LeavFacade f4 = new LeavFacadeImpl(handlerRequest4);
		System.out.println("**************");
	}

}
