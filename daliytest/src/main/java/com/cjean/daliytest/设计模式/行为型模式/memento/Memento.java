package com.cjean.daliytest.设计模式.行为型模式.memento;
/**
 * 备忘录类
 * 	对备忘内容进行存储
 * @author Cjean
 *
 */
public class Memento {
	private String ename;
	
	private int age;
	
	private double salar;

	public Memento(Emp emp) {
		this.ename = emp.getEname();
		this.age = emp.getAge();
		this.salar = emp.getSalar();
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalar() {
		return salar;
	}

	public void setSalar(double salar) {
		this.salar = salar;
	}

	@Override
	public String toString() {
		return "Memento [ename=" + ename + ", age=" + age + ", salar=" + salar + "]";
	}
	
	
	
	
}
