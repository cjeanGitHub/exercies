package com.cjean.daliytest.���ģʽ.��Ϊ��ģʽ.mediator;
/**
 *   ���ż� ����ݵ��н�
 *   	��������  ������  �г�����   ��������֮���໥����  ͨ�� �ܾ���  ��ʵ������ת��   �ܾ���ʵ���н�ӿ�
 *   
 *   �����·�����
 *   ����ע�᷽��
 * @author Cjean
 *
 */
public interface Mediator {
	void command(String dname);
	
	 void register(String dname, Department department);
}
