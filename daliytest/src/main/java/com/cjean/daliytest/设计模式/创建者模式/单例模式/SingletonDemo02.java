package com.cjean.daliytest.���ģʽ.������ģʽ.����ģʽ;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * ����ʽ����  
 * 	˽�������Լ�������  ֻ�Ѷ������Ⱪ¶
 * �е��ӳټ��� �������أ�������Ч�ʲ���  �̰߳�ȫ
 * @author Cjean
 *
 */
public class SingletonDemo02 implements Serializable{
	
	// �����ǵ���   ��פstatic һ������
	private static SingletonDemo02 instance;

	private SingletonDemo02() {
		if(null != instance) {
			throw new RuntimeException();
		}
	}
	
	// �̰߳�ȫ  ���ǵ���  Ч�����ܽ���
	public static synchronized SingletonDemo02 getInstance() {
		if(null == instance) {
			instance = new SingletonDemo02();
		}
		return instance;
	}
	public Object readResolve() throws ObjectStreamException{
		return instance;
	}

}
