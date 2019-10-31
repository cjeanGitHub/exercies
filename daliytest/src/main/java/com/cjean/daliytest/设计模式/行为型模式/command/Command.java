package com.cjean.daliytest.设计模式.行为型模式.command;

/**
 * 命令接口
 * 抽象命令类
 * @author Cjean
 *
 */
public interface Command {
	void execute();
}

class ConcretCommand implements Command{
	
	private Receiver Receiver;

	public ConcretCommand(com.cjean.daliytest.设计模式.行为型模式.command.Receiver receiver) {
		super();
		Receiver = receiver;
	}


	@Override
	public void execute() {
		//发送前
		//。。。逻辑
		Receiver.action();
		//发送后
		//。。。逻辑
	}
	
}