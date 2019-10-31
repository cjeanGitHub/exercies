package com.cjean.daliytest.string;

public class StringArr {
	public static void main(String[] args) {
		String[] a = {"a","b","c","d"};
		String[] b = new String[3];
		String[] c = delTheEle(a,2);
		
 		System.arraycopy(a, 3, a, 2, 1);
 		
 		
 		

 	//	System.arraycopy("数据源", "拷贝数据源的位置","目的地", "放进目的地下表位置", "拷贝长度");
 		
 		for(int i=0;i<a.length;i++) {
 			System.out.println(i+"---"+a[i]);
 		}
 		System.out.println("=============");
 		for(int i=0;i<b.length;i++) {
 			System.out.println(i+"---"+b[i]);
 		}
 		System.out.println("=============");
 		for(int i=0;i<c.length;i++) {
 			System.out.println(i+"---"+c[i]);
 		}
	}
	
	public static String[] delTheEle(String[] s, int index) {
		System.arraycopy(s, index, s, index-1, s.length-index);
		String[] s1 = new String[s.length-1];
		System.arraycopy(s, 0, s1, 0, s.length-1);
		
		return s1;
	}
}
