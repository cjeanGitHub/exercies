package com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ����  JDK �Ķ�̬����ģʽ
 * ������ⲿ����  ���Բ���Ҫ ֱ�ӶԽӽ�ɫ  ֻҪ�Ҵ����ɫ�ͺ�
 * 
 * @author Cjean
 *
 */
public class Client {
	public static void main(String[] args) {
		/**
		 * �ڶ���
		 */
		dynamicProxy02();
		/**
		 * ��1��
		 */
//		dynamicProxy01();
	}
	
	static void dynamicProxy02() {
		/**
		 * �ڶ���
		 */
		// ������ʵ���ܽӿ�����   �Լ�   ��ʵ����
		ProxyInter trueModel = new TrueModel();
		ProxyInter newProxyInstance =(ProxyInter) Proxy.newProxyInstance(
				trueModel.getClass().getClassLoader()
				, trueModel.getClass().getInterfaces()
				, new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("::::::::::");
						Object re = null;
						Object mes = method.invoke(trueModel, args);
						if(null != mes && !"".equals(mes)) {
//							System.out.println(":if:");
							re = mes;
						}
						return re;
					}
				});
		newProxyInstance.Response();
		System.out.println("***********");
		String mes = newProxyInstance.Up("iosdjgo");
		System.out.println("����ǣ�==="+mes);
		System.out.println("***********");
		
	}
	
	static void dynamicProxy01() {
		/**
		 * ��һ��
		 */
		// ������ʵ���ܽӿ�����   �Լ�   ��ʵ����
		ProxyInter trueModel = new TrueModel();
		// ���ɴ������  �Լ� ����  ��ʵ���ܽӿ�����
		ProxyModel proxyModel = new ProxyModel(trueModel);
		// ����Proxy�������ж� �������ļ���
		ProxyInter newProxyInstance = (ProxyInter) Proxy.newProxyInstance(
				//  ������ ȥ���ط���
				ClassLoader.getSystemClassLoader()
				// ���� �����ӿ�
				, new Class[] {ProxyInter.class}
				// ���� ʵ��InvocationHandler�ӿڵĴ������   InvocationHandler
				, proxyModel);
		newProxyInstance.Response();
		System.out.println("**************");
		String rs = newProxyInstance.Up("qwert");
		System.out.println("result:***"+rs);
	}

}
