package com.cjean.daliytest.datastructandalgorithm;
/**
 * 高斯算法
 * 1+2+...+100=？
 * @author chu_c
 *
 */
public class GaosiAlgotithm {
	static int sum = 0;

	public static void main(String[] args) {
//		normalAlgorithm();
//		gaosiAlgorithm();
		
		int result = recursiveAlgorithm(1);
		System.out.println("result:"+result);
	}
	public static int recursiveAlgorithm(int i) {
		sum += i;
		if(i == 100) {
			return sum;
		}
		return recursiveAlgorithm(1+i);
	}
	
	/**
	 * 高斯算法
	 */
	public static void gaosiAlgorithm() {
		int sum=0;
		int dataNum = (100-1+1);//数据个数
		sum = ((1+100)*dataNum/2);
		System.out.println(sum);
	}
	
	/**
	 * 一般算法
	 */
	public static void normalAlgorithm() {
		int sum = 0;
		for(int i=0;i<101;i++) {
			sum += i;
		}
		System.out.println(sum);
	}
}
