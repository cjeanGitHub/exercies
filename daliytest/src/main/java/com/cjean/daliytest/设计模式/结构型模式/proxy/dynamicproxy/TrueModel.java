package com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.proxy.dynamicproxy;
/**
 * ���ǽ�ɫ  �ṩ��ʵ��ɫ�Ĺ���
 * 	���ܽ��� �ṩ���蹦��
 * @author Cjean
 *
 */
public class TrueModel implements ProxyInter{
	
	@Override
	public void Response() {
		System.out.println("�ṩ��ʵ��ɫ ������");		
	}

	@Override
	public String Up(String mes) {
		System.out.println("TrueModel  Up()");
		return mes.toUpperCase();
	}
	 		

}
