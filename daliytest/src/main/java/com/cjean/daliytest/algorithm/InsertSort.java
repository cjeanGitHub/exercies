package com.cjean.daliytest.algorithm;

import com.cjean.daliytest.util.StringArrUtil;

/**
 * ���������㷨
 * 
 * @author chu_c
 *
 */
public class InsertSort {

	@SuppressWarnings("static-access")
	public static void sort(int[] arr) {
		
		StringArrUtil stringArrUtil = new StringArrUtil();
		System.out.println("����ǰ��");
		stringArrUtil.printArr(arr);
		System.out.println();
		for (int i = 1; i < arr.length; i++) {
			// �������
			int insertVal = arr[i];
			// �������λ��(׼����ǰһ�����Ƚ�)
			int index = i - 1;
			// �����������ȱ��������С
			while (index >= 0 && insertVal < arr[index]) {
				// ���� arr[index] ����ƶ�
				arr[index + 1] = arr[index];
				// �� index ��ǰ�ƶ�
				index--;
			}
			// �Ѳ�������������λ��
			arr[index + 1] = insertVal;
			System.out.println();
			System.out.println("����"+i);
			stringArrUtil.printArr(arr);
		}
		System.out.println();
		System.out.println("�����");
		stringArrUtil.printArr(arr);
	}

	public static void main(String[] args) {
		int[] args1 = { 12, 134, 195, 21, 1, 61, 981, 88};
		int[] args2 = null;
		sort(args1);
	}

}
