package com.cjean.daliytest.���ģʽ.������ģʽ.����ģʽ;

import java.io.Serializable;

/**
 * ��̬�ڲ���ģʽ   
 * 	�̰߳�ȫ  ����  
 * 		�߳�
	
 * 	˽�������Լ�������  ֻ�Ѷ������Ⱪ¶
 * �е��ӳټ��� �������أ�������Ч�ʸ�  �̰߳�ȫ
 * @author Cjean
 *
 */
public class SingletonDemo04 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SingletonDemo04() {
		
	}

	private static class SingletonDemo04Instance{
		// �����ǵ���   ��פstatic һ������
		private static SingletonDemo04 instance = new SingletonDemo04();
	}
	
	// �̰߳�ȫ  ���ǵ���  Ч�����ܽ���
	public static SingletonDemo04 getInstance() {
		return SingletonDemo04.SingletonDemo04Instance.instance;
	}

}
