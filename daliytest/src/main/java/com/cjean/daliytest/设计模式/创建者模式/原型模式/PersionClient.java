package com.cjean.daliytest.���ģʽ.������ģʽ.ԭ��ģʽ;

import com.cjean.daliytest.util.CloneUtil;
import sun.invoke.util.BytecodeDescriptor;

import java.util.Date;

public class PersionClient {
	public static void main(String[] args) throws Exception {

		//ͨ����д clone���� ʵ����ȿ�¡  �ﵽclone ʱ ����ʵ��һ�� ��Ա����
		cloneByDeepClone();

		//cloneByQianClone();//ͨ��ʵ��cloneable�ӿ� ��дclone����ʵ�ֶ����ǳ��¡
		//cloneBySer();//ͨ�����л������л�ʵ�ֶ���Ŀ�¡

	}
	//ͨ����д clone���� ʵ����ȿ�¡  �ﵽclone ʱ ����ʵ��һ�� ��Ա����
	public static void cloneByDeepClone()throws Exception{
		Car car = new Car(300,"benz");
		Person3 person = new Person3("cjean",20,car);
		System.out.println("====person=="+person+"========");

		Person3 person1Clone = (Person3)person.clone();
		person1Clone.getCar().setName("BYD");
		System.out.println("====person1Clone=="+person1Clone+"========");
		System.out.println("====person=222="+person+"========");
	}
	//ͨ��ʵ��cloneable�ӿ� ��дclone����ʵ�ֶ����ǳ��¡
	public static void cloneByQianClone()throws Exception{
		Car car = new Car(300,"benz");
		Person2 person = new Person2("cjean",20,car);
		System.out.println("====person=="+person+"========");

		Person2 person1Clone = (Person2)person.clone();
		person1Clone.getCar().setName("BYD");
		System.out.println("====person1Clone=="+person1Clone+"========");
		System.out.println("====person=222="+person+"========");
	}
//ͨ�����л������л�ʵ�ֶ���Ŀ�¡
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
