package com.cjean.daliytest.���ģʽ.��Ϊ��ģʽ.memento;

import java.util.HashMap;

public class Client {
	public static void main(String[] args) {
		
		HashMap<String, String> hashMap = new HashMap<String,String>();
		
		
		for(int i=0;i<27;i++) {
			hashMap.put(""+i, "No--"+i);
		}

		System.out.println("��һ�α���¼############"+hashMap.size());
		
		System.out.println("��һ�α���¼############"+hashMap.size());
		

		System.out.println("��һ�α���¼############"+hashMap.size());
		
		
		System.out.println("��һ�α���¼############");
		

//		Emp emp = new Emp("chu",12,999);
//		
//		System.out.println("��������  emp��"+emp.toString());
//		
//		System.out.println("��һ�α���¼############");
//		Memento memento = emp.memento();
//		
//		CareTaker careTaker = new CareTaker();
//		careTaker.setMemento(memento);
//		System.out.println("��������  memento��"+memento.toString());
//		
//		System.out.println("############");
//		
//		emp = new Emp("��",12,899);
//		
//		System.out.println("��������  emp��"+emp.toString());
//		System.out.println("���ݻָ�   ############");
//		
//		emp.recover(careTaker.getMemento());
//
//		System.out.println("���ݻָ�   ############"+emp.toString());
		
	}
}
