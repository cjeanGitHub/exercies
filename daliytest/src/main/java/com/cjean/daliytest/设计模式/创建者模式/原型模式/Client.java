package com.cjean.daliytest.设计模式.创建者模式.原型模式;

import java.util.Date;

public class Client {
	public static void main(String[] args) throws Exception {
		Date date = new Date(12312345678L);
		Student student1 = new Student(1,"小米",date);
		System.out.println(student1.toString());//Student [id=1, name=小米]
		System.out.println("****************");
		// 执行已存在对象的 clone方法 进行 对象的赋值
		Student clone = (Student) student1.clone();
		System.out.println(clone.toString());//Student [id=1, name=小米]
		System.out.println("****************");
		
		// 对clone对象进行属性修改  实验是否会影响到 原型 (结论：基本类型以及字符串不会影响原型的属性值，)
		/*clone.setId(2);
		System.out.println(student1.toString());//Student [id=1, name=小米]
		System.out.println(clone.toString());//Student [id=2, name=小米]
		System.out.println("****************");
		clone.setName("小红");
		System.out.println(student1.toString());//Student [id=1, name=小米]
		System.out.println(clone.toString());//Student [id=2, name=小红]
		System.out.println("****************");
		clone.setBirthDay(new Date(12312345678L));
		System.out.println(student1.toString());//Student [id=1, name=小米, birthDay=Thu Jul 11 16:32:41 GMT+08:00 2019]
		System.out.println(clone.toString());//Student [id=2, name=小红, birthDay=Sat May 23 20:05:45 GMT+08:00 1970]
		System.out.println("*********原对象*******");*/
		// 对原对象进行属性修改  实验是否会影响到 原型 (结论：)
		student1.setId(211);
		System.out.println(student1.toString());//Student [id=1, name=小米]
		System.out.println(clone.toString());//Student [id=2, name=小米]
		System.out.println("********原对象********");
		student1.setName("小红11");
		System.out.println(student1.toString());//Student [id=1, name=小米]
		System.out.println(clone.toString());//Student [id=2, name=小红]
		System.out.println("*******原对象*********");
		student1.setBirthDay(new Date(1231L));
		System.out.println(student1.toString());//Student [id=1, name=小米, birthDay=Thu Jul 11 16:32:41 GMT+08:00 2019]
		System.out.println(clone.toString());//Student [id=2, name=小红, birthDay=Sat May 23 20:05:45 GMT+08:00 1970]
		System.out.println("*******原对象*********");
		
		// 
	}
}
