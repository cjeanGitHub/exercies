package com.cjean.daliytest.设计模式.行为型模式.chain;

public class HandlerRequest {
	private String name;
	
	private int leavDays;
	
	private String reason;

	/**
	 * @param name
	 * @param leavDays
	 * @param reason
	 */
	public HandlerRequest(String name, int leavDays, String reason) {
		super();
		this.name = name;
		this.leavDays = leavDays;
		this.reason = reason;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLeavDays() {
		return leavDays;
	}

	public void setLeavDays(int leavDays) {
		this.leavDays = leavDays;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
