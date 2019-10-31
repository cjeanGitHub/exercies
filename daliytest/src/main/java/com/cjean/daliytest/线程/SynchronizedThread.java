package com.cjean.daliytest.线程;

import java.util.ArrayList;
import java.util.List;
/**
 * 在使用synchronized进行安全布置时   要确定安全要素是什么，从而对安全要素进行监视器设置   
 * 
 *当对对象进行锁时   可以锁class 也可以对处理方法进行锁
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
		new Thread(new HapperCustomer(cinema,2),"理").start();
		new Thread(new HapperCustomer(cinema,6),"文").start();
	}
	
	public void testSynchronized01() {
		List<String> list = new ArrayList<>();
		for(int i=0;i<10000;i++) {
			new Thread(()->{
	//				list.add(""+i);//未增加对象锁   会有线程安全问题
					synchronized(list) {//list就是需要 监视的对象   
						list.add(""+Thread.currentThread().getName());
					}
			}).start();
		}	
		try {
			Thread.sleep(10);
			System.out.println("=====");
			System.out.println("数量（线程不安全的）："+list.size());
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
			System.out.println("想买："+seats+"，但是目前只有"+avilable);
			return false;
		}else {
			System.out.println("想买："+seats+"，目前还有"+avilable);
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
				System.out.println("买上票了");
				cinema.avilable -= seat;
			}else {
				System.err.println("没买上票了");
			}
		}
	}
	
}