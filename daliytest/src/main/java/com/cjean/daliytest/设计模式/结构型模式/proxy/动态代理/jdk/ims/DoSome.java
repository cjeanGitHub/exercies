package com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.proxy.��̬����.jdk.ims;

import com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.proxy.��̬����.jdk.interfac.IDoSome;

public class DoSome implements IDoSome{

	@Override
	public String doFirst() {
		System.out.println("ִ��dofirst....");
		return "asdf";
	}

	@Override
	public void doSecond() {
		System.out.println("ִ��doSecond....");
	}
	
}
