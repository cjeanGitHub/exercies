package com.cjean.daliytest;

public class TestSup {

	public static void main(String[] args) {

		new Sub(3);
	}

}
class Super{
	int flage = 1;
	public Super() {
		show();
	}
	void show(){
		System.out.println("Super  show() flage:"+flage);
	}
}
class Sub extends Super{
	int flage2 = 4;
	public Sub(int i) {
		flage = i;
		System.out.println("Sub  Sub() flage:"+flage);
	}
	void show(){
		System.out.println("Sub  show() flage:"+flage2);
	}
	
}