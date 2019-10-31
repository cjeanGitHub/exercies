package com.cjean.daliytest.algorithm;

/**
 * √∞≈›À„∑®
 * @author chu_c
 *
 */
public class BubbleSort {
	
	public static void bubbleSortMethod(int[] args) {
		int len = args.length;
		int temp;
		
		for(int i=0;i<len;i++) {
			for(int j=1;j<len-i;j++) {
				if(args[j]<args[j-1]){
					temp = args[j-1];
					args[j-1] = args[j];
					args[j] = temp;
				}	
			}
			System.out.print(i+"--");
			for(int k=0;k<len;k++) {
				System.out.print(args[k]+",");
			}
			System.out.println();
		}
		for(int i=0;i<len;i++) {
			System.out.print(args[i]+",");
		}
	}
	public static void main(String[] args) {
		int[] args1 = {12,134,195,21,1,61,981,88};
		bubbleSortMethod(args1);
	}

}
