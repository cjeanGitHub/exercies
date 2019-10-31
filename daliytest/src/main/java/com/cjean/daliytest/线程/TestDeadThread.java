package com.cjean.daliytest.线程;

public class TestDeadThread {

	public static void main(String[] args) throws InterruptedException {
		MarkUp markUp1 = new MarkUp(0,"小红");
		MarkUp markUp2 = new MarkUp(1,"小白");
		markUp1.start();
		markUp2.start();
	}
}
class MarkUp extends Thread{
	private int choice;
	private String name;
	// 这里对资源进行static 修饰  此时内存（方法去中只有一份此类对象）这种情况会造成死锁，否则不会产生死锁
	static Lipstick lipstick = new Lipstick();
	static Mirror mirror = new Mirror();
	
	public MarkUp(int choice, String name) {
		super();
		this.choice = choice;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			markUp();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void markUp() throws InterruptedException {
		if(0==choice) {
			synchronized(lipstick) {
				System.out.println(name+"先涂口红");
				Thread.sleep(1000);
				
//				synchronized (mirror) {
//				  System.out.println(name+"1秒后，去拿镜子");
//				}
			}
		}else {
			synchronized(mirror) {
				System.out.println(name+"先拿镜子");
				Thread.sleep(2000);
				System.out.println(name+"2秒后，去涂口红");

//				synchronized (lipstick) {
//				  System.out.println(name+"2秒后，去涂口红");
//				}
			}
		}
	}
}
class Lipstick{
	
}
class Mirror{
	
}
