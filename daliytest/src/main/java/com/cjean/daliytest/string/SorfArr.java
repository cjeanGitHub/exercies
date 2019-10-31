package com.cjean.daliytest.string;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;

public class SorfArr {
//	private final static int MA = 123;
	public static void main(String[] args) {
		Date d ;
	//	Arrays.copyOf(original, newLength)
	//	MA = 12344;
		int[] a = {1,3,2,4,9,8,10,22,6,444,56,97895,65,324};
		int temp = 0;
 		for(int i=0;i<a.length;i++) {
 			for(int j=1;j<a.length-i;j++) {
 				if(a[j]<a[j-1]) {
 					temp = a[j];
 					a[j] = a[j-1];
 					a[j-1] = temp;
 				}
 				System.out.println(Arrays.toString(a));
 			}
 			System.out.println("======0000====");
 			System.out.println(Arrays.toString(a));
 		}
 		System.out.println("=====1111=====");
 		System.out.println(Arrays.toString(a));
 		
 		System.out.println(getBinarySearch(a, 6));
 		

	}
	
	public static int getBinarySearch(int[] arr, int value) {
		int low = 0;
		int hight = arr.length-1;
		
		while(low<=hight) {
			int mid = (low+hight)/2;
			if(value == arr[mid]) {
				return mid;
			}
			if(value < arr[mid]) {
				hight = mid-1;
			}
			if(value > arr[mid]) {
				low = mid+1;
			}
		}
		
		return -1;
	}
	
	
}
