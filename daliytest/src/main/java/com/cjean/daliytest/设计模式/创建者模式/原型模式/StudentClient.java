package com.cjean.daliytest.���ģʽ.������ģʽ.ԭ��ģʽ;

import java.util.Date;

public class StudentClient {
	public static void main(String[] args) throws Exception {

		Date date = new Date(12312345678L);
		Student student1 = new Student(1,"С��",date);
		System.out.println(student1.toString());//Student [id=1, name=С��]
		System.out.println("****************");
		// ִ���Ѵ��ڶ���� clone���� ���� ����ĸ�ֵ
		Student clone = (Student) student1.clone();
		System.out.println(clone.toString());//Student [id=1, name=С��]
		System.out.println("****************");
		
		// ��clone������������޸�  ʵ���Ƿ��Ӱ�쵽 ԭ�� (���ۣ����������Լ��ַ�������Ӱ��ԭ�͵�����ֵ��)
		/*clone.setId(2);
		System.out.println(student1.toString());//Student [id=1, name=С��]
		System.out.println(clone.toString());//Student [id=2, name=С��]
		System.out.println("****************");
		clone.setName("С��");
		System.out.println(student1.toString());//Student [id=1, name=С��]
		System.out.println(clone.toString());//Student [id=2, name=С��]
		System.out.println("****************");
		clone.setBirthDay(new Date(12312345678L));
		System.out.println(student1.toString());//Student [id=1, name=С��, birthDay=Thu Jul 11 16:32:41 GMT+08:00 2019]
		System.out.println(clone.toString());//Student [id=2, name=С��, birthDay=Sat May 23 20:05:45 GMT+08:00 1970]
		System.out.println("*********ԭ����*******");*/
		// ��ԭ������������޸�  ʵ���Ƿ��Ӱ�쵽 ԭ�� (���ۣ�)
		student1.setId(211);
		System.out.println(student1.toString());//Student [id=1, name=С��]
		System.out.println(clone.toString());//Student [id=2, name=С��]
		System.out.println("********ԭ����********");
		student1.setName("С��11");
		System.out.println(student1.toString());//Student [id=1, name=С��]
		System.out.println(clone.toString());//Student [id=2, name=С��]
		System.out.println("*******ԭ����*********");
		student1.setBirthDay(new Date(1231L));
		System.out.println(student1.toString());//Student [id=1, name=С��, birthDay=Thu Jul 11 16:32:41 GMT+08:00 2019]
		System.out.println(clone.toString());//Student [id=2, name=С��, birthDay=Sat May 23 20:05:45 GMT+08:00 1970]
		System.out.println("*******ԭ����*********");
		
		// 
	}
}
