package com.cjean.daliytest.刑侏;

public class TestGeneric {

	public static void main(String[] args) {
		
		MyCollection myCollection = new MyCollection();
		myCollection.set("込込込込", 0);
		myCollection.set(124, 1);
		System.out.println(myCollection.get(1));
		
		MyCollection2<String> myCollection2 = new MyCollection2<String>();
		myCollection2.set("込込込込2222", 0);
	//	myCollection2.set(124, 1);
		System.out.println(myCollection2.get(0));
		
	}

}
class MyCollection2<E>{
	Object[] objs = new Object[5];
	
	public void set(E e, int index) {
		objs[index] = e;
	}
	
	public E get(int index) {
		return (E)objs[index];
	}
}

class MyCollection{
	Object[] objs = new Object[5];
	
	public void set(Object obj, int index) {
		objs[index] = obj;
	}
	
	public Object get(int index) {
		return objs[index];
	}
}
