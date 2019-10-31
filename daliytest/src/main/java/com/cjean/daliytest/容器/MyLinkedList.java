package com.cjean.daliytest.容器;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class MyLinkedList<E> {
	private Node<E> first;
	private Node<E> last;
	private int size;
	
	private void add(E e) {
		
		if(first!=null) {
			Node<E> newNode = new Node<E>(e, last, null);
			last.next = newNode;
			last = newNode;
		}else {
			Node<E> newNode = new Node<E>();
			newNode.element = e;
			first = newNode;
			last = newNode;
		}
		size++;
	}
	
	private Node<E> getNode(int index){
		if(index > (size-1) || index < 0) {
			throw new RuntimeException("索引下表检测有误："+index);
		}
		
		Node<E> temp = null;
		if(index<(size>>1)) {
			temp = first;
			for(int i=0;i<index;i++) {
				temp = temp.next;
			}
		}else {
			temp = last;
			for(int i=size-1;i>index;i--) {
				temp = temp.prve;
			}
		}
		return temp;
	}
	
	private void insert(int index,E e) {
		if(index > (size-1) || index < 0) {
			throw new RuntimeException("索引下表检测有误："+index);
		}
		Node<E> temp = getNode(index);
		Node<E> tempPrve = temp.prve;
		Node<E> newTemp = new Node<E>(e, tempPrve, temp);
		tempPrve.next = newTemp;
		temp.prve = newTemp;
		size++;
	}
	
	private void remove(int index) {
		if(index > (size-1) || index < 0) {
			throw new RuntimeException("索引下表检测有误："+index);
		}
		Node<E> temp = getNode(index);
		Node<E> tempPrve = temp.prve;
		Node<E> tempNext = temp.next;
		
		tempPrve.next = tempNext;
		tempNext.prve = tempPrve;
		temp = null;
		size--;
	}
	
	public String toString() {
		StringBuilder dataBuile = new StringBuilder();
		dataBuile.append("[");

		for(int i=0;i<size;i++) {
			dataBuile.append(getNode(i).element+",");
		}
		dataBuile.append("]");
		return dataBuile.toString().replace(",]", "]");
	}


	public static void main(String[] args) {
		MyLinkedList<String> myLinkedList = new MyLinkedList<String>();
		myLinkedList.add("1111");
		myLinkedList.add("2222");
		myLinkedList.add("3333");
		myLinkedList.add("4444");
		System.out.println("ok");
		
		System.out.println("ok"+myLinkedList.getNode(1).element);
		System.out.println("ok"+myLinkedList.toString());

		myLinkedList.remove(2);
		System.out.println("ok"+myLinkedList.toString());
		
		myLinkedList.insert(1, "hhhh");
		System.out.println("ok"+myLinkedList.toString());

		myLinkedList.insert(3, "qqqqq");
		System.out.println("ok"+myLinkedList.toString());
	}

	public static class Node<E>{
		E element;
		Node<E> prve;
		Node<E> next;
		public Node(E element, Node<E> prve, Node<E> next) {
			super();
			this.element = element;
			this.prve = prve;
			this.next = next;
		}
		public Node() {
			super();
		}
	}
}


