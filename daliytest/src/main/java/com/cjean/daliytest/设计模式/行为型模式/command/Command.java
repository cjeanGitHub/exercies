package com.cjean.daliytest.���ģʽ.��Ϊ��ģʽ.command;

/**
 * ����ӿ�
 * ����������
 * @author Cjean
 *
 */
public interface Command {
	void execute();
}

class ConcretCommand implements Command{
	
	private Receiver Receiver;

	public ConcretCommand(com.cjean.daliytest.���ģʽ.��Ϊ��ģʽ.command.Receiver receiver) {
		super();
		Receiver = receiver;
	}


	@Override
	public void execute() {
		//����ǰ
		//�������߼�
		Receiver.action();
		//���ͺ�
		//�������߼�
	}
	
}