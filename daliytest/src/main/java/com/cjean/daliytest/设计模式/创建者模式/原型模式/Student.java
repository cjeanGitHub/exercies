package com.cjean.daliytest.设计模式.创建者模式.原型模式;

import java.util.Date;

public class Student implements Cloneable {
	private int id;
	private String name;
	private Date birthDay;
	
	
	public Student(int id, String name, Date birthDay) {
		this.id = id;
		this.name = name;
		this.setBirthDay(birthDay);
	}
	public Student() {
		super();
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object clone = super.clone();
		return clone;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", birthDay=" + birthDay + "]";
	}
	
}
