package com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.proxy.��̬����.CGLB.proxy;

import java.lang.reflect.Method;

import com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.proxy.��̬����.CGLB.ims.DoSome;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * cglb�ǻ���û�нӿڵĶ�̬����
 * ����û�нӿ� ������Ҫ�Լ���д��̬������
 * �Լ���д�Ĵ�������Ҫʵ��MethodInterceptor��������������
 * ��������Ҫ��д �����������ӿڵķ���
 * 
 * ����cglb��ʽ������û��ʵ�ֽӿڵģ�������Ҫ������Ļ�������ǿ����һ��˵������������ǿ���ࣩ
 * 
 * 
 */

public class MyCGLBProxy implements MethodInterceptor{
	private DoSome target;
//	private IDoSome target;

	public MyCGLBProxy(DoSome target) {
		super();
		this.target = target;
	}
	
	public MyCGLBProxy() {
		
	}
	//��ǿ����
	public Object MyCGLB() {
		//��ǿ��
		Enhancer enhancer = new Enhancer();
//		Enhancer enhancer = new Enhancer();
		//ָ������ ��Ŀ����  ��ʼ��ǿ����
		enhancer.setSuperclass(DoSome.class);
//		enhancer.setSuperclass(IDoSome.class);
		//ָ���������
		enhancer.setCallback(this);
		
		return enhancer.create();
//		return (IDoSome)enhancer.create();
		
	}

	@Override
	public Object intercept(Object arg
			, Method method
			, Object[] obj
			, MethodProxy methodProxy) throws Throwable {
		Object invoke = method.invoke(target, obj);
		System.out.println("qian");
		if (null != invoke) {
			((String)invoke).toUpperCase();
		}
		System.out.println("hou");
		return invoke;
	}
	
}
