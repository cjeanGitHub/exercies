package com.cjean.daliytest.���ģʽ.������ģʽ.����ģʽ;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class Test {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		// ö��ʽ
//		test04();
		System.out.println("*******4********");
		
		//���Ե���--��̬�ڲ���
//			test03();
			System.out.println("*******3********");
		//���Ե���--����ʽ
//			test02();
			System.out.println("*******2********");
		//���Ե���--����ʽ
			test01();
			System.out.println("*******1********");
	}
	// ö��ʽ
	public static void test04() {
		// ö��ʽ
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
	
	// ����ģʽ---��̬�ڲ���   ��ϵĶ���ʽ�Լ�����ʽ���е�   �̰߳�ȫ �����ʸ�  ֧���ӳټ���
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
			
			// �ƽⵥ��ģʽ
			
		try {
			Class<SingletonDemo04> clazz = (Class<SingletonDemo04>) Class.forName("com.cjean.daliytest.���ģʽ.����ģʽ.SingletonDemo04");
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
	
	//���� ������  �е��µ���Ч�ʲ���  �̰߳�ȫ  ֧�������أ���ʱ���أ�  ֻ����Ҫ��ʱ���ٵ��á�������ʡ�ڴ�ռ�
	public static void test02() throws Exception {
		SingletonDemo02 instance = SingletonDemo02.getInstance();
		System.out.println("ǰ��"+instance);
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
			// �ƽⵥ��ģʽ
//			try {
//				Class<SingletonDemo02> clazz = (Class<SingletonDemo02>) Class.forName("com.cjean.daliytest.���ģʽ.����ģʽ.SingletonDemo02");
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
			

			// ���л��Լ������к��ƽ�
				//���Ƚ�����������ļ���  Ϊ�����л���׼��

			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("F:/single.txt"));
			oos.writeObject(instance);
			oos.flush();
			oos.close();
			
				//��ȡ��������Ϣ ���з����л�
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("F:/single.txt"));

			SingletonDemo02 instance2 = (SingletonDemo02) ois.readObject();
			System.out.println("��"+instance2);
			//����ƽ� ����   �ڶ������������Ӷ��������Ƿ���ڵ��ж�  ��������򷵻� ����ʱ�쳣  ���򣨲����ڣ�����������ʵ����
			
			// ����ƽ����л��Լ������л�  �ķ�ʽ��  ���ǵ�ȥ���������
			
		
	}
	
	//���� ����ʽ����ģʽ ��֧�������أ���ʱ���أ� ���� ����Ч�ʸ�  �̰߳�ȫ   ���������ڴ�ռ�õ�����
	public static void test01() throws Exception {
		SingletonDemo01 demo = SingletonDemo01.getInstance();
		System.out.println("SingletonDemo01--��"+demo);
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
			// �ƽⵥ��ģʽ
		// ͨ������ķ�ʽ�����ƽ�
		try {
			Class<SingletonDemo01> clazz = (Class<SingletonDemo01>) Class.forName(
					"com.cjean.daliytest.���ģʽ.������ģʽ.����ģʽ.SingletonDemo01");
			Constructor<SingletonDemo01> c = clazz.getDeclaredConstructor(null);
			c.setAccessible(true);
			SingletonDemo01 c1 = (SingletonDemo01) c.newInstance(null);
			System.out.println("c1:"+c1);

			SingletonDemo01 c2 = (SingletonDemo01) c.newInstance(null);
			System.out.println("c2:"+c2);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// ͨ�����л��Լ������л��ķ�ʽ�����ƽ�
		ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream("D:/single.txt"));
		oos.writeObject(demo);
		oos.flush();
		oos.close();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:/single.txt"));
		SingletonDemo01 demo1 = (SingletonDemo01) ois.readObject();
		System.out.println("�����л���SingletonDemo01--��"+demo1);
		
		//����ƽ� ����   �ڶ������������Ӷ��������Ƿ���ڵ��ж�  ��������򷵻� ����ʱ�쳣  ���򣨲����ڣ�����������ʵ����
		
		// ����ƽ����л��Լ������л�  �ķ�ʽ��  ���ǵ�ȥ���������
		
		
		
	}
}
