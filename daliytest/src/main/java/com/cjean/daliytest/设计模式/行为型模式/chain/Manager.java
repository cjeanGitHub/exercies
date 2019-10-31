package com.cjean.daliytest.���ģʽ.��Ϊ��ģʽ.chain;

public class Manager extends Leader {
	private String name;
	
	private Leader nextLeader;
	
	/**
	 * @param name
	 * @param nextLeader
	 */
	public Manager(String name) {
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
		if(10 > leavDays) {
			System.out.println("����ǩ�ˣ���");
		}else {
			nextLeader.handlerRequest(request);
		}
	}

}
