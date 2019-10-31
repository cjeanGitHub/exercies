package com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.proxy.��̬����.jdk.proxy;

import com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.proxy.��̬����.jdk.ims.DoSome;
import com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.proxy.��̬����.jdk.interfac.IDoSome;

public class DoSomeProxy implements IDoSome{
	private IDoSome target;

	public DoSomeProxy(IDoSome target) {
//		super();
		this.target = target;
	}

	@Override
	public String doFirst() {
		String mes = null;
		String rs = target.doFirst();
		if (null != rs) {
			mes = rs.toUpperCase();
		}
		return mes;
	}

	@Override
	public void doSecond() {
		System.out.println("ִ�� DoSomeProxy -��-doSecond....");
	}
	
}
