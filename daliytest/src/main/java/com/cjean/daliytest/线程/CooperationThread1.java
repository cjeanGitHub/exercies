package com.cjean.daliytest.�߳�;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * ���̲߳���Э��1--�̷ܳ�  4����ɲ���  ����ಢ����ģʽ  ������������ģʽ
 * 
 * 
 * ͨ�������� ����߲���Э��
 * 
 * @author Cjean
 *
 */
public class CooperationThread1 {

	public static void main(String[] args) throws InterruptedException {
		SynContainer synContainer = new SynContainer();
		new Product(synContainer).start();
		new Consumer(synContainer).start();
 
	}
}
// ������
class Product extends Thread{
	SynContainer synContainer;
	
	public Product(SynContainer synContainer) {
		this.synContainer = synContainer;
	}
	@Override
	public void run() {
//		SynContainer synContainer = new SynContainer();//  ����ϰ������  ������һ���ֲ����� ��� main��ִ���߳� countʼ��Ϊ0  ������ʼ��Ϊnull
		for(int i=0;i<100;i++) {
			SteamdeBun s = new SteamdeBun(""+i);
			synContainer.push(s);
			System.out.println("������ͷ��"+i);
		}
		System.out.println("������ͷ��===");
		System.out.println("������ͷ��===");
	}
}
// ������
class Consumer extends Thread{
	static SynContainer synContainer;
	public Consumer(SynContainer synContainer) {
		this.synContainer = synContainer;
		System.out.println("������ͷ��Consumer");
	}
	@Override
	public void run() {
		System.out.println("������ͷ��");
		for(int i=0;i<100;i++) {
			System.out.println("������ͷ��"+synContainer.pop().id);
		}
	}
}
// ��������
class SynContainer{
	//�洢����
	SteamdeBun[] steamdeBunArr = new SteamdeBun[10];
	int count = 0;
	
	//����洢����
	public synchronized void push(SteamdeBun steamdeBun) {
		System.out.println("push-count"+count);
		System.out.println("���ȣ�"+steamdeBunArr.length);
		System.out.println("����2��"+count);
		while(count == steamdeBunArr.length) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notifyAll();
		steamdeBunArr[count] = steamdeBun;
		count++;
	}
	// ȡ���������
	public synchronized SteamdeBun pop(){
		System.out.println("pop-count"+count);
		while(0 == count) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notifyAll();
		count--;
		SteamdeBun steamdeBun = steamdeBunArr[count];
		return steamdeBun;
	}
}
// ���Ѷ���
class SteamdeBun{
	String id;

	public SteamdeBun(String id) {
		this.id = id;
	}
}

