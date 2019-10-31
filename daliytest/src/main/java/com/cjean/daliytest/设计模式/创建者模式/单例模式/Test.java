package com.cjean.daliytest.设计模式.创建者模式.单例模式;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class Test {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		// 枚举式
//		test04();
		System.out.println("*******4********");
		
		//测试单例--静态内部类
//			test03();
			System.out.println("*******3********");
		//测试单例--懒汉式
//			test02();
			System.out.println("*******2********");
		//测试单例--饿汉式
			test01();
			System.out.println("*******1********");
	}
	// 枚举式
	public static void test04() {
		// 枚举式
		new Thread(()->{
			SingletonDemo05.Instance.singltonOperation();
		}) .start();
		try {
			Thread.sleep(1000);
			System.out.println(SingletonDemo05.Instance == SingletonDemo05.Instance );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 单例模式---静态内部类   结合的饿汉式以及懒汉式的有点   线程安全 调用率高  支持延迟加载
	public static void test03() throws Exception {
//		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				System.out.println(SingletonDemo04.getInstance());
			}).start();;
			try {
				Thread.sleep(1000);
				System.out.println(SingletonDemo04.getInstance());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("==============");
//		}
			
			// 破解单例模式
			
		try {
			Class<SingletonDemo04> clazz = (Class<SingletonDemo04>) Class.forName("com.cjean.daliytest.设计模式.单例模式.SingletonDemo04");
			Constructor<SingletonDemo04> c = clazz.getDeclaredConstructor(null);
			c.setAccessible(true);
			SingletonDemo04 c1 = (SingletonDemo04) c.newInstance(null);
			System.out.println("c1:"+c1);

			SingletonDemo04 c2 = (SingletonDemo04) c.newInstance(null);
			System.out.println("c2:"+c2);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//测试 懒加载  有点事调用效率不高  线程安全  支持懒加载（延时加载）  只在需要的时候再调用、创建节省内存空间
	public static void test02() throws Exception {
		SingletonDemo02 instance = SingletonDemo02.getInstance();
		System.out.println("前："+instance);
//		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				System.out.println(SingletonDemo02.getInstance());
			}).start();;
			try {
				Thread.sleep(1000);
				System.out.println(SingletonDemo02.getInstance());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("=============");
//		}
			// 破解单例模式
//			try {
//				Class<SingletonDemo02> clazz = (Class<SingletonDemo02>) Class.forName("com.cjean.daliytest.设计模式.单例模式.SingletonDemo02");
//				Constructor<SingletonDemo02> c = clazz.getDeclaredConstructor(null);
//				c.setAccessible(true);
//				SingletonDemo02 c1 = (SingletonDemo02) c.newInstance(null);
//				System.out.println("c1:"+c1);
//
//				SingletonDemo02 c2 = (SingletonDemo02) c.newInstance(null);
//				System.out.println("c2:"+c2);
//				
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
			

			// 序列化以及反序列胡破解
				//首先将对象类读进文件中  为反序列化做准备

			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("F:/single.txt"));
			oos.writeObject(instance);
			oos.flush();
			oos.close();
			
				//读取对象类信息 进行反序列化
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("F:/single.txt"));

			SingletonDemo02 instance2 = (SingletonDemo02) ois.readObject();
			System.out.println("后："+instance2);
			//如何破解 反射   在对象构造器中增加对象引用是否存在的判断  如果存在则返回 运行时异常  否则（不存在）进行正常的实例化
			
			// 如果破解序列话以及反序列化  的方式呢  还是得去看对象类的
			
		
	}
	
	//测试 饿汉式单例模式 不支持懒加载（延时加载） 但是 调用效率高  线程安全   会有无用内存占用的问题
	public static void test01() throws Exception {
		SingletonDemo01 demo = SingletonDemo01.getInstance();
		System.out.println("SingletonDemo01--》"+demo);
//		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				System.out.println(SingletonDemo01.getInstance());
			}).start();;
			try {
				Thread.sleep(1000);
				System.out.println(SingletonDemo01.getInstance());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("--------------------");
//		}
			// 破解单例模式
		// 通过反射的方式进行破解
		try {
			Class<SingletonDemo01> clazz = (Class<SingletonDemo01>) Class.forName(
					"com.cjean.daliytest.设计模式.创建者模式.单例模式.SingletonDemo01");
			Constructor<SingletonDemo01> c = clazz.getDeclaredConstructor(null);
			c.setAccessible(true);
			SingletonDemo01 c1 = (SingletonDemo01) c.newInstance(null);
			System.out.println("c1:"+c1);

			SingletonDemo01 c2 = (SingletonDemo01) c.newInstance(null);
			System.out.println("c2:"+c2);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 通过序列化以及反序列化的方式进行破解
		ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream("D:/single.txt"));
		oos.writeObject(demo);
		oos.flush();
		oos.close();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:/single.txt"));
		SingletonDemo01 demo1 = (SingletonDemo01) ois.readObject();
		System.out.println("反序列化的SingletonDemo01--》"+demo1);
		
		//如何破解 反射   在对象构造器中增加对象引用是否存在的判断  如果存在则返回 运行时异常  否则（不存在）进行正常的实例化
		
		// 如果破解序列话以及反序列化  的方式呢  还是得去看对象类的
		
		
		
	}
}
