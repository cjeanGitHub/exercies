package com.cjean.daliytest.���ģʽ.��Ϊ��ģʽ.chain;

public class Manager3 extends Leader {
	private String name;
	
	private Leader nextLeader;
	
	/**
	 * @param name
	 * @param nextLeader
	 */
	public Manager3(String name) {
		super();
		this.name = name;
	}
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Leader getNextLeader() {
		return nextLeader;
	}


	public void setNextLeader(Leader nextLeader) {
		this.nextLeader = nextLeader;
	}


	@Override
	public void handlerRequest(HandlerRequest request) {
		int leavDays = request.getLeavDays();
			System.out.println("����Manager3ǩ�ˣ���"+leavDays+"�������죡");
	}

}
