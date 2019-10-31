package com.cjean.daliytest.容器;

import java.util.ArrayList;
import java.util.Arrays;

public class MyArrayList<E> {

	private Object[] elementData;

	private int size;

	private int count;

	private static final int DEFAULT_CAPACITY = 5;

	public MyArrayList() {
		elementData = new Object[DEFAULT_CAPACITY];
	}
	
	public MyArrayList(int capacity) {
		elementData = new Object[capacity];
	}

	public void add(E obj) {
		// 自动扩容
		int elementDataLength = elementData.length;
		if (elementDataLength == size) {// 如果数组的长度和容器集合的大小一致时 并且出现在增加方法中时 进行自动扩容
			int newDataLength = elementDataLength + (elementDataLength >> 1);
			elementData = Arrays.copyOf(elementData, newDataLength);
		}

		elementData[size++] = obj;
	}

	public void add(int index, E obj) {
		// 自动扩容
		int elementDataLength = elementData.length;
		if (elementDataLength == size) {// 如果数组的长度和容器集合的大小一致时 并且出现在增加方法中时 进行自动扩容
			int newDataLength = elementDataLength + (elementDataLength >> 1);
			elementData = Arrays.copyOf(elementData, newDataLength);
		}
		System.arraycopy(elementData, index, elementData, index + 1, elementDataLength - index - 1);
		elementData[index] = obj;
	}

	public String toString() {
		StringBuilder elementStr = new StringBuilder();
		elementStr.append("[");
		for (int i = 0; i < size; i++) {

			elementStr.append(elementData[i] + ",");
		}
		elementStr.append("]");

		return elementStr.toString().replace(",]", "]");
	}

	public void del(int index) {
		// 自动扩容
		System.arraycopy(elementData, index + 1, elementData, index, size - 1 - index);
		elementData[--size] = null;
	}
	
	public E get(int index) {
		return (E) elementData[index];
	}
	
	private void set() {
		
		
	}
	
	private void checkIndex(int index) {
		if(index > size || index < 0) {
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
		}
	}
	
	private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }


	public static void main(String[] args) {
		MyArrayList myArrayList = new MyArrayList();
		myArrayList.add("1111");
		myArrayList.add("3333");
		myArrayList.add("4");
		myArrayList.add("5");
		myArrayList.add("6");
		myArrayList.add("7");
		myArrayList.add("8");
		myArrayList.add("9");
		myArrayList.add("10");
		myArrayList.add(1, "2222");

		myArrayList.del(0);
		System.out.println("====");
		System.out.println(myArrayList.size);
		System.out.println(myArrayList.elementData.length);
		System.out.println("====");
		myArrayList.del(2);
		myArrayList.del(4);
		System.out.println("====");
		System.out.println(myArrayList.size);
		System.out.println(myArrayList.elementData.length);
		System.out.println("====");
		System.out.println(myArrayList.size);
		System.out.println(myArrayList.elementData.length);
		for(int i=0;i<myArrayList.size;i++) {
		//	myArrayList.get(i);
			System.out.println(myArrayList.get(i));
		}
		System.out.println(myArrayList.toString());


	}

	public static void testArrListRemove() {
		ArrayList<String> myArrayList1 = new ArrayList<String>();

		myArrayList1.add("1111");
		myArrayList1.add("3333");
		myArrayList1.add("4");
		myArrayList1.add("5");
		myArrayList1.add("6");
		myArrayList1.add("7");
		myArrayList1.add("8");
		myArrayList1.add("9");
		myArrayList1.add("10");
		myArrayList1.add(1, "2222");

		Object[] a = myArrayList1.toArray();

		for (Object q : a) {
			System.out.println(q.toString());
		}

		String w = myArrayList1.remove(2);
		String e = myArrayList1.remove(5);

		System.out.println("w:" + w + "===e:" + e);

		Object[] c = myArrayList1.toArray();

		for (Object q : c) {
			System.out.println(q.toString());
		}
	}

}
