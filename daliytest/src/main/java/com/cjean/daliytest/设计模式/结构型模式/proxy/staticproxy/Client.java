package com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.proxy.staticproxy;

/**
 * ���Ծ�̬����ģʽ
 * ������ⲿ����  ���Բ���Ҫ ֱ�ӶԽӽ�ɫ  ֻҪ�Ҵ����ɫ�ͺ�
 * @author Cjean
 *
 */
public class Client {
	public static void main(String[] args) {
		//���� �����ɫ
		new ProxyModel(new TrueModel()).Response();
	}

}
