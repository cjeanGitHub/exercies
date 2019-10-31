package com.cjean.daliytest.设计模式.行为型模式.memento;

/**
 *源发器类
 *	负责对备忘录结构的存储 
 * @author Cjean
 *
 */
public class Emp {
	
	private String ename;
	
	private int age;
	
	private double salar;
	
	public Memento memento() {
		return new Memento(this);
	}
	
	public void recover(Memento mmt) {
		this.ename = mmt.getEname();
		this.age = mmt.getAge();
		this.salar = mmt.getSalar();
	}
	

	public Emp(String ename, int age, double salar) {
		super();
		this.ename = ename;
		this.age = age;
		this.salar = salar;
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
		return "Emp [ename=" + ename + ", age=" + age + ", salar=" + salar + "]";
	}
	
	

}
