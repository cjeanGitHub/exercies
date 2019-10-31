package com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * �����ɫ  ��Ҫ�����ṩ  ��ʵ��ɫ  �Լ�  ��ʵ��ɫ�Ĺ���
 * 	������Ҫʵ��InvocationHandler�Ľӿ�  �Լ� ������ʵ��ɫ���ɹ���������ʵ������
 * 
 * 	ʹ��JDK�Դ���Proxy��������ʵ�ֶ�̬����
 * 
 * 
 * InvocationHandler�ӿ�
 * 	InvocationHandler �Ǵ���ʵ���ĵ��ô������ ʵ�ֵĽӿڡ� 
	ÿ������ʵ��������һ�������ĵ��ô�����򡣶Դ���ʵ�����÷���ʱ�����Է������ý��б��벢����ָ�ɵ����ĵ��ô������� invoke ������ 
	
	
 * @author Cjean
 *
 */
public class ProxyModel implements InvocationHandler {

	private ProxyInter ProxyInter;
	
	public ProxyModel(ProxyInter ProxyInter) {
//		super();
		this.ProxyInter = ProxyInter;
	}

	/**
	 * invoke
		Object invoke(Object proxy,
              Method method,
              Object[] args)
              throws Throwable�ڴ���ʵ���ϴ��������ò����ؽ�������뷽�������Ĵ���ʵ���ϵ��÷���ʱ�����ڵ��ô�������ϵ��ô˷����� 

		������
		proxy - �����ϵ��÷����Ĵ���ʵ��
		method - ��Ӧ���ڴ���ʵ���ϵ��õĽӿڷ����� Method ʵ����Method ����������ཫ�����������������Ľӿڣ��ýӿڿ����Ǵ��������Լ̳з���
		�Ĵ���ӿڵĳ��ӿڡ�
		args - �����������ʵ���Ϸ������õĲ���ֵ�Ķ������飬����ӿڷ�����ʹ�ò�������Ϊ null��
		�������͵Ĳ�������װ���ʵ�������װ���ࣨ�� java.lang.Integer �� java.lang.Boolean����ʵ���С� 
		���أ�
		�Ӵ���ʵ���ķ������÷��ص�ֵ������ӿڷ������������������ǻ������ͣ���˷������ص�ֵһ������Ӧ������װ�������ʵ����
		������һ���ǿɷ��䵽�����������͵����͡�����˷������ص�ֵΪ null ���ҽӿڷ����ķ��������ǻ������ͣ�
		�����ʵ���ϵķ������ý��׳� NullPointerException����������˷������ص�ֵ�������ӿڷ����������������Ͳ����ݣ�
		�����ʵ���ϵķ������ý��׳� ClassCastException�� 
		�׳��� 
		Throwable - �Ӵ���ʵ���ϵķ��������׳����쳣�����쳣�����ͱ�����Է��䵽�ڽӿڷ����� 
		throws �Ӿ�����������һ�쳣���ͻ�δ�������쳣���� java.lang.RuntimeException �� java.lang.Error��
		����˷����׳����������쳣�����쳣���ɷ��䵽�ڽӿڷ����� throws �Ӿ�����������һ�쳣���ͣ�
		����ʵ���ķ������ý��׳������˷������׳����쳣�� UndeclaredThrowableException��
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		/**
		 * ���ⲿ���д���Ĺ��ܶ������˴����д���   
		 * ���ͬʱ����Ϊ������� �ڴ�����ʵ����֮ǰ��֮�󶼿��Խ��ж��صĴ���
		 * 
		 */
		// �ڴ���֮ǰ��Ҫ��ɶ��  ��Ǯ�ɣ��� 
		Object rs = null;
		System.out.println("�������ģ���");
		Object mes = method.invoke(ProxyInter, args);
		if(null != mes && !"".equals(mes)) {
			rs = mes;
			//���ڴ��� �з���ֵ��  ������   ��û�з���ֵ�ķ��������������
			System.out.println("���ڴ�������");
		}
		System.out.println("�������");
		//������ɵ�  �����ж���Ǯ��
		return rs;
	}

	

}
