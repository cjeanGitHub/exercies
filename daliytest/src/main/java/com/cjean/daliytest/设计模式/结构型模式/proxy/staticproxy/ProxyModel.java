package com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.proxy.staticproxy;

/**
 * �����ɫ  ��Ҫ�����ṩ  ��ʵ��ɫ  �Լ�  ��ʵ��ɫ�Ĺ���
 * 	������Ҫʵ�ֹ��ܵĽӿ�  �Լ� ������ʵ��ɫ���ɹ���������ʵ������
 * @author Cjean
 *
 */
public class ProxyModel implements ProxyInter {

	private TrueModel trueModel;
	
	public ProxyModel(TrueModel trueModel) {
//		super();
		this.trueModel = trueModel;
	}

	@Override
	public void Response() {
		//....�����ɫ���
		System.out.println("����ʵ��ɶ���ܵģ���");
		//....�����ɫ���
		
		//�������ֻ����ʵ��ɫ�������
		trueModel.Response();
		
		//....�����ɫ���
		System.out.println("�㿴������������𣿣���");
		//....�����ɫ���
	}
	

}
