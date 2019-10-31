package com.cjean.daliytest.���ģʽ.��Ϊ��ģʽ.chain;

public abstract class Leader {
	protected String name;
	
	protected Leader nextLeader;

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
	
	public abstract void handlerRequest(HandlerRequest request);
	
}
