package com.cjean.daliytest.�߳�;

import java.util.Arrays;
import java.util.List;

public class LambdaThread {
	static class Like2 implements ILike{
		public void lambda() {
			System.out.println("����like2��");
		}
	}

	public static void main(String[] args) {
		String[] a = {"1","2","3","4","a","s","d","q","w"}; 
		List<String> alst = Arrays.asList(a);
		alst.forEach((al)->System.out.print(al+";"));
		System.out.println("����like2��");
		alst.forEach(System.out::print);
		
//		ILike like = new Like();
//		like.lambda();
//		ILike like2 = new Like2();
//		like2.lambda();
//		
//		//lambda  jdk1.8
//		ILike like3 = new ILike() {
//			public void lambda() {
//				System.out.println("ambda  jdk1.8  ����like2��");
//			}
//		};
//		like3.lambda();
		
		
	}
	
	

}
interface ILike{
	void lambda();
}
class Like implements ILike{
	public void lambda() {
		System.out.println("����like��");
	}
	
}
