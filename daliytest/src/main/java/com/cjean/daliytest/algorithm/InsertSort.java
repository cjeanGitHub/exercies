package com.cjean.daliytest.algorithm;

import com.cjean.daliytest.util.StringArrUtil;

/**
 * 插入排序算法
 * 
 * @author chu_c
 *
 */
public class InsertSort {

	@SuppressWarnings("static-access")
	public static void sort(int[] arr) {
		
		StringArrUtil stringArrUtil = new StringArrUtil();
		System.out.println("排序前：");
		stringArrUtil.printArr(arr);
		System.out.println();
		for (int i = 1; i < arr.length; i++) {
			// 插入的数
			int insertVal = arr[i];
			// 被插入的位置(准备和前一个数比较)
			int index = i - 1;
			// 如果插入的数比被插入的数小
			while (index >= 0 && insertVal < arr[index]) {
				// 将把 arr[index] 向后移动
				arr[index + 1] = arr[index];
				// 让 index 向前移动
				index--;
			}
			// 把插入的数放入合适位置
			arr[index + 1] = insertVal;
			System.out.println();
			System.out.println("排序："+i);
			stringArrUtil.printArr(arr);
		}
		System.out.println();
		System.out.println("排序后：");
		stringArrUtil.printArr(arr);
	}

	public static void main(String[] args) {
		int[] args1 = { 12, 134, 195, 21, 1, 61, 981, 88};
		int[] args2 = null;
		sort(args1);
	}

}
