package com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.proxy.��̬����.CGLB.test;

import com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.proxy.��̬����.CGLB.ims.DoSome;
import com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.proxy.��̬����.CGLB.proxy.MyCGLBProxy;

public class test{
	public static void main(String[] args) {
		
		
		
		DoSome ser = new DoSome();
//		IDoSome ser = new DoSome();
		String re = ser.doFirst();
		System.out.println("-->"+re);
		// ����CGLB�Ķ�̬����
		DoSome cglbSer = new MyCGLBProxy(ser).MyCGLB();
		
		String mes = cglbSer.doFirst();
		System.out.println(mes);
		cglbSer.doSecond();
		

	}
	
}
