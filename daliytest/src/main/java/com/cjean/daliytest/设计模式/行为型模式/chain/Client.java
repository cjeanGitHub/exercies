package com.cjean.daliytest.���ģʽ.��Ϊ��ģʽ.chain;

public class Client {

	public static void main(String[] args) {
		HandlerRequest handlerRequest1 = new HandlerRequest("С��",8,"ѧ������");
		HandlerRequest handlerRequest2 = new HandlerRequest("С��",13,"ѧ������");
		HandlerRequest handlerRequest3 = new HandlerRequest("С��",35,"ѧ������");
		HandlerRequest handlerRequest4 = new HandlerRequest("С��",99,"ѧ������");
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
