package com.cjean.daliytest.容器;

import java.util.HashMap;

public class MyHashMap<K, V> {
	
	private Node2<K,V>[] table;
	
	
	private int size;
	

	private static final int DEFAULT_CAPACITY = 16;
	
	MyHashMap(){
		table = new Node2[DEFAULT_CAPACITY];
	}
	
	private void put(K key,V value) {
		int tableCapacity = table.length;
		int hash = getMyhash(key, tableCapacity);
		Node2<K,V> temp = getNode(hash);
		Node2<K,V> newNode = new Node2<K,V>(hash, key, value, null);
		Node2<K,V> lastNode = new Node2<K,V>();
		boolean backUpFlage = true;
		if(temp == null) {
			table[hash] = newNode;
		}else {
			while(temp != null) {
				//处理重复的情况
				if(temp.key.equals(key)) {
					temp.value = value;
					backUpFlage = false;
					break;
				}else {
					lastNode = temp;
					temp = temp.next;
				}
			}
			if(backUpFlage) {//出现重复就不插入
				lastNode.next = newNode;
			}
		}
		if(backUpFlage) {
			size++;
		}
		
	}
	
	private void remove(Object key) {
		int hash = getMyhash(key, table.length);
		Node2<K, V> node = table[hash];
		Node2<K, V> nextNode = null;
		Node2<K, V> prveNode = null;
		if(node != null) {
			while(node != null) {
				if(node.key.equals(key)) {
					System.out.println(node.value+"--"+node.key);
					nextNode = node.next;
					
					//如果删除正好是第一个  那直接吧第一个的设为null
					if(prveNode != null) {//不是第一个  
						prveNode.next = nextNode;
					}else {//是第一个
						node = null;
					}
//					System.out.println(node.value+"--"+node.key);
					break;
				}
				prveNode = node;
				node = node.next;
				
			}
		}
		table[hash] = node;
		size--;
	}
	
	private String get(Object key) {
		int hash = getMyhash(key, table.length);
		Node2<K, V> node = table[hash];
		String mes = "[ 未找到]";
		if(node != null) {
			while(node != null) {
				if(node.key.equals(key)) {
					mes = "[ "+node.key+":"+node.value+"]";
					break;
				}
				node = node.next;
			}
		}
		return mes;
	}
	
	 @Override
	public String toString() {
		 StringBuilder sb = new StringBuilder();
		 Node2<K,V> node = null;
		 Node2<K,V> nextNode = null;
		 sb.append("[");
		 for(int i=0;i<table.length;i++) {
			 node = getNode(i);
			 if(node != null) {
				 nextNode = node.next;
				 if(nextNode!=null) {
					 while(nextNode!=null) {
						 node = nextNode;
						 sb.append("[hash=" + node.hash + ", key=" + node.key + ", value=" + node.value + ", next=" + node.next + "]");
						 nextNode = nextNode.next;
					 }
				 }else {
					 sb.append("[hash=" + node.hash + ", key=" + node.key + ", value=" + node.value + ", next=" + node.next + "]");
				 } 
			 }
			 
			
		 }
		 
		 sb.append("]");
		 
		return sb.toString();
	}
	
	private Node2<K,V> getNode(int hash) {
		Node2<K,V> node = null;
		node = table[hash];
		return node; 
	}
	
	private static int getMyhash(Object key, int tableCapacity) {
//		int h = key.hashCode();
//		return h&(tableCapacity-1);
		
		int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}
	
	
	public static void main(String[] args) {
//		HashMap<K, V>
		MyHashMap myHashMap = new MyHashMap<Integer, String>();
		
		myHashMap.put(1111, "qqqq");
		myHashMap.put(2222, "www");
		myHashMap.put(3333, "eee");
		myHashMap.put(4444, "rr");
		myHashMap.put(5555, "ttt");

		System.out.println("======数量====="+myHashMap.size);

		myHashMap.put(2222, "哈哈哈哈哈");

		System.out.println("======数量====="+myHashMap.size);
		for(int i=0;i<100;i++) {
			myHashMap.put(i, "NO---"+i);
		}
		
		

		System.out.println("======数量====="+myHashMap.size);
		System.out.println("===========");
		System.out.println("=====get(1)======"+myHashMap.get(1));

		System.out.println("=====get(17)======"+myHashMap.get(17));
		
		System.out.println(myHashMap.toString());

		System.out.println("===========");

		System.out.println(myHashMap.get(2222));
		
		myHashMap.remove(2222);
		System.out.println("======删了=====");
		System.out.println("======数量====="+myHashMap.size);

		System.out.println(myHashMap.get(2222)+"======删了=====");
		System.out.println("======数量====="+myHashMap.size);

		System.out.println(myHashMap.get(2222)+"======删了=====");
		
//		for(int i=0;i<40;i++) {
//			Integer a = new Integer(i);
//			
//			System.out.print(i+"----"+a.hashCode()+",");
//		}
		
	}

}
class Node2<K,V>{
	public int hash;
	public K key;
	public V value;
	public Node2 next;
	public Node2(int hash, K key, V value, Node2 next) {
		super();
		this.hash = hash;
		this.key = key;
		this.value = value;
		this.next = next;
	}
	public Node2() {
		super();
	}
	@Override
	public String toString() {
		return "Node2 [hash=" + hash + ", key=" + key + ", value=" + value + ", next=" + next + "]";
	}
	
	
	
}
