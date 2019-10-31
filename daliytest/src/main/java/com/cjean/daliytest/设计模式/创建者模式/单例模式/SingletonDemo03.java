package com.cjean.daliytest.���ģʽ.������ģʽ.����ģʽ;

import java.io.Serializable;

/**
 * ˫�ؼ����ģʽ   
 * 	�̰߳�ȫ  ����  
 * 		�������� JVM�ڲ��Ż������Լ� �ײ�ģ�͵�ԭ����� ִ��˳��ȷ��������   ������ʹ��
	
 * 	˽�������Լ�������  ֻ�Ѷ������Ⱪ¶
 * �е��ӳټ��� �������أ�������Ч�ʲ���  �̰߳�ȫ
 * @author Cjean
 *
 */
public class SingletonDemo03 implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5574950688524446901L;
	// �����ǵ���   ��פstatic һ������
	private static SingletonDemo03 instance;

	private SingletonDemo03() {
		
	}
	
	// �̰߳�ȫ  ���ǵ���  Ч�����ܽ���
	public static SingletonDemo03 getInstance() {
		if(null != instance) {
			return instance;
		}else {
			synchronized (SingletonDemo04.class) {
				instance = new SingletonDemo03();
				return instance;
			}
		}
	}

}
