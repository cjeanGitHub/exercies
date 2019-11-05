package com.cjean.daliytest.设计模式.创建者模式.原型模式;

import com.cjean.daliytest.util.CloneUtil;
import sun.invoke.util.BytecodeDescriptor;

import java.util.Date;

public class PersionClient {
	public static void main(String[] args) throws Exception {

		//通过重写 clone方法 实现深度克隆  达到clone 时 重新实例一个 成员对象
		cloneByDeepClone();

		//cloneByQianClone();//通过实现cloneable接口 重写clone方法实现对象的浅克隆
		//cloneBySer();//通过序列化反序列化实现对象的克隆

	}
	//通过重写 clone方法 实现深度克隆  达到clone 时 重新实例一个 成员对象
	public static void cloneByDeepClone()throws Exception{
		Car car = new Car(300,"benz");
		Person3 person = new Person3("cjean",20,car);
		System.out.println("====person=="+person+"========");

		Person3 person1Clone = (Person3)person.clone();
		person1Clone.getCar().setName("BYD");
		System.out.println("====person1Clone=="+person1Clone+"========");
		System.out.println("====person=222="+person+"========");
	}
	//通过实现cloneable接口 重写clone方法实现对象的浅克隆
	public static void cloneByQianClone()throws Exception{
		Car car = new Car(300,"benz");
		Person2 person = new Person2("cjean",20,car);
		System.out.println("====person=="+person+"========");

		Person2 person1Clone = (Person2)person.clone();
		person1Clone.getCar().setName("BYD");
		System.out.println("====person1Clone=="+person1Clone+"========");
		System.out.println("====person=222="+person+"========");
	}
//通过序列化反序列化实现对象的克隆
	public static void cloneBySer()throws Exception{
		Car car = new Car(300,"benz");
		Person person = new Person("cjean",20,car);

		System.out.println("====person=="+person+"========");

		Person person1Clone = (Person) CloneUtil.clone(person);
		person1Clone.getCar().setName("BYD");
		System.out.println("====person1Clone=="+person1Clone+"========");
		System.out.println("====person=222="+person+"========");
	}
}
