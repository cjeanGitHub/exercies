package com.cjean.daliytest.���ģʽ.��Ϊ��ģʽ.iterator;
/**
 * ���������� �ӿ�
 * @author Cjean
 *
 */
public interface Myiterator {
	boolean isFirst();// �ǲ��ǵ�һ��
	
	boolean isLast();// �ǲ������һ��
	
	boolean hasNext();// �ǲ��ǻ�����һ��
	
	void first();// ��һ��
	
	void last();// ���һ��
	
	Object getCurrentObj();// ��ȡ��ǰ�α��µ�����

	void next();// ��һ���α�һ��
}
