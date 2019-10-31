package com.cjean.daliytest.设计模式.行为型模式.memento;

import java.util.HashMap;

public class Client {
	public static void main(String[] args) {
		
		HashMap<String, String> hashMap = new HashMap<String,String>();
		
		
		for(int i=0;i<27;i++) {
			hashMap.put(""+i, "No--"+i);
		}

		System.out.println("第一次备忘录############"+hashMap.size());
		
		System.out.println("第一次备忘录############"+hashMap.size());
		

		System.out.println("第一次备忘录############"+hashMap.size());
		
		
		System.out.println("第一次备忘录############");
		

//		Emp emp = new Emp("chu",12,999);
//		
//		System.out.println("创建对象  emp："+emp.toString());
//		
//		System.out.println("第一次备忘录############");
//		Memento memento = emp.memento();
//		
//		CareTaker careTaker = new CareTaker();
//		careTaker.setMemento(memento);
//		System.out.println("备忘对象  memento："+memento.toString());
//		
//		System.out.println("############");
//		
//		emp = new Emp("清",12,899);
//		
//		System.out.println("创建对象  emp："+emp.toString());
//		System.out.println("数据恢复   ############");
//		
//		emp.recover(careTaker.getMemento());
//
//		System.out.println("数据恢复   ############"+emp.toString());
		
	}
}
