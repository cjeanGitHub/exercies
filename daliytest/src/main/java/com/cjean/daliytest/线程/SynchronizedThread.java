package com.cjean.daliytest.�߳�;

import java.util.ArrayList;
import java.util.List;
/**
 * ��ʹ��synchronized���а�ȫ����ʱ   Ҫȷ����ȫҪ����ʲô���Ӷ��԰�ȫҪ�ؽ��м���������   
 * 
 *���Զ��������ʱ   ������class Ҳ���ԶԴ�����������
 * @author Cjean
 *
 */
public class SynchronizedThread {

	public static void main(String[] args) throws InterruptedException {
		SynchronizedThread synchronizedThread = new SynchronizedThread();
		synchronizedThread.testSynchronized02();
	//	synchronizedThread.testSynchronized01();
	}
	
	public void testSynchronized02() {
		HappyCinema cinema = new HappyCinema(20, "sxt");
		new Thread(new HapperCustomer(cinema,2),"��").start();
		new Thread(new HapperCustomer(cinema,6),"��").start();
	}
	
	public void testSynchronized01() {
		List<String> list = new ArrayList<>();
		for(int i=0;i<10000;i++) {
			new Thread(()->{
	//				list.add(""+i);//δ���Ӷ�����   �����̰߳�ȫ����
					synchronized(list) {//list������Ҫ ���ӵĶ���   
						list.add(""+Thread.currentThread().getName());
					}
			}).start();
		}	
		try {
			Thread.sleep(10);
			System.out.println("=====");
			System.out.println("�������̲߳���ȫ�ģ���"+list.size());
			System.err.println("===err==");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
class HappyCinema{
	int avilable;
	String name;
	public HappyCinema(int avilable, String name) {
		super();
		this.avilable = avilable;
		this.name = name;
	}
	public boolean bookTickes(int seats) {
		if(avilable<seats) {
			System.out.println("����"+seats+"������Ŀǰֻ��"+avilable);
			return false;
		}else {
			System.out.println("����"+seats+"��Ŀǰ����"+avilable);
			return true;
		}
	}
}
class HapperCustomer implements Runnable{
	HappyCinema cinema;
	int seat;
	
	public HapperCustomer(HappyCinema cinema, int seat) {
		super();
		this.cinema = cinema;
		this.seat = seat;
	}

	@Override
	public void run() {
		synchronized(cinema) {
			boolean flag = cinema.bookTickes(seat);
			if(flag) {
				System.out.println("����Ʊ��");
				cinema.avilable -= seat;
			}else {
				System.err.println("û����Ʊ��");
			}
		}
	}
	
}