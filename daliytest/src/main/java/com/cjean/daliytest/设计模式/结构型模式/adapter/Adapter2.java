package com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.adapter;
/**
 * ������������ 
 * 
 *  	���� �������� ������ Ŀ��ӿ��ṩ����
 *  
 *  
 * @author chu_c
 *
 */
public class Adapter2 implements Target {
	private Adaptee adaptee;

	public Adapter2(Adaptee adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public void HandlReq() {
		adaptee.request();
	}
	
}
