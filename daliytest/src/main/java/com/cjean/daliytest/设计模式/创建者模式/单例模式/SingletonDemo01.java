package com.cjean.daliytest.���ģʽ.������ģʽ.����ģʽ;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * ����ʽ����  
 * 	˽�������Լ�������  ֻ�Ѷ������Ⱪ¶
 * @author Cjean
 *
 */
//ͨ��io��д�ƽ����ʽ����ģʽ ��Ҫʵ��  implements Serializable  �ӿ���ʵ�ֶ�д����
//implements Serializable  
public class SingletonDemo01{
	
	private static final long serialVersionUID = -2857572878017706543L;
	// �����ǵ���ģʽ  
	private static SingletonDemo01 instance = new SingletonDemo01();

	private SingletonDemo01() {
		// ��� ��Ϊ�վͷ��� ����ʱ�쳣�����ⷴ����ɵ� �����ƽ⣩
		//˵���������ͱ���ͨ�����������ù��������ƽⵥ��
		if(null != instance) {
			throw new RuntimeException();
		}
	}
	
	public static SingletonDemo01 getInstance() {
		return instance;
	}
	
	// ��ֹ��ȡ ������ �������л��Լ������л��ķ�ʽ���� �������ƽ�
	//˵������������ǻ��ڻص��ģ������л�ʱ�����������readResolve()��ֱ�ӷ��ش˷���ָ���Ķ��󣬶�����Ҫ�ڴ����µĶ���
	public Object readResolve() throws ObjectStreamException{
		return instance;
	}
	

}
