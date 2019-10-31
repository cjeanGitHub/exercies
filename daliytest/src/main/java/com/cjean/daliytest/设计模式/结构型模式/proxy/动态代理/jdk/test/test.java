package com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.proxy.��̬����.jdk.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.proxy.��̬����.jdk.ims.DoSome;
import com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.proxy.��̬����.jdk.interfac.IDoSome;
import com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.proxy.��̬����.jdk.proxy.DoSomeProxy;

public class test{
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		Class c = Class.forName("com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.proxy.��̬����.jdk.ims.DoSome");
		IDoSome ser1 = (DoSome)(c.newInstance());
		String re1 = ser1.doFirst();
		System.out.println("-->"+re1);

		System.out.println("-->-----------------");
		IDoSome ser = new DoSome();
		String re = ser.doFirst();
		System.out.println("-->"+re);
		/*//��̬����  ������ѧϰ����ʵ�ֽӿڻ��߼̳�class����ʽ �����Ǿ�̬�������׳����౬ը������
		IDoSome ser = new DoSome();
		String re = ser.doFirst();
		System.out.println("-->"+re);
		IDoSome serproxy = new DoSomeProxy(ser);
		String reProxy = serproxy.doFirst();
		System.out.println("-->"+reProxy);*/
		
		// ��̬����
		
		IDoSome dynamicSer = (IDoSome)Proxy.newProxyInstance(
				//���ش�������ࣩ
				ser.getClass().getClassLoader()
				//���ش�����Ľӿ�
				, ser.getClass().getInterfaces()
				// ʹ�������ڲ��� �����ж�̬���� ���� ʵ����ķ���
				, new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						String mes = null;
						Object rs = method.invoke(ser, args);
						if(null != rs) {
							mes = re.toString().toUpperCase();
						}
						return mes;
					}
				});
		String mes = dynamicSer.doFirst();
		System.out.println(mes);
		dynamicSer.doSecond();
		

	}
	
}
