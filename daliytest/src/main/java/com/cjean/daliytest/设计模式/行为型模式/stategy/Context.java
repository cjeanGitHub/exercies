package com.cjean.daliytest.���ģʽ.��Ϊ��ģʽ.stategy;

/**
 * ����;���Ĳ��Խ���
 * �����Ļ���������㷨��ֱ�ӵĿͻ��˵��÷����ˣ��ǵ��㷨���Զ����ڿͻ��˵ı仯
 * ���ʹ��spring������ע�빦�ܣ�������ͨ�������ļ�����̬ע�벻ͬ���Զ��󣬶�̬���л���ͬ���㷨
 * @author Cjean
 *
 */
public class Context {
	private Stategy stategy;//��ǰ���õ��㷨����

	//����ͨ��������ע��
	public Context(Stategy stategy) {
		super();
		this.stategy = stategy;
	}
	
	
	
	public Stategy getStategy() {
		return stategy;
	}


//ͨ��set����ע��
	public void setStategy(Stategy stategy) {
		this.stategy = stategy;
	}



	public void getPrice(double price) {
		System.out.println("Contextע��");
		System.out.println(stategy.getPrice(price));
	}
}
