package com.cjean.daliytest.���ģʽ.��Ϊ��ģʽ.stategy;
/**
 *   �����ڿ�������жԲ�ͬ��������if�жϽ�������ͬ���㷨
 *   	�������ά���У����������ԭ���еĿ���ԭ��  ,���Ҵ����߼��ر�
 *   		�����������ʩ��  ���ģʽ�еĲ���ģʽ��stategy��
 * @author Cjean
 *
 */
public class TestStategy {
	public double getPeice(String type, double price) {
		if ("��ͨ�ͻ�С����".equals(type)) {
			return price;
		} else if ("��ͨ�ͻ�������".equals(type)) {
			return (price*0.9);
		}else if ("�Ͽͻ�������".equals(type)) {
			return (price*0.8);
		}else if ("�Ͽͻ�С����".equals(type)) {
			return (price*0.85);
		}
		
		return price;
	}
}
