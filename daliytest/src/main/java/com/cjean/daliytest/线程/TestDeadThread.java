package com.cjean.daliytest.�߳�;

public class TestDeadThread {

	public static void main(String[] args) throws InterruptedException {
		MarkUp markUp1 = new MarkUp(0,"С��");
		MarkUp markUp2 = new MarkUp(1,"С��");
		markUp1.start();
		markUp2.start();
	}
}
class MarkUp extends Thread{
	private int choice;
	private String name;
	// �������Դ����static ����  ��ʱ�ڴ棨����ȥ��ֻ��һ�ݴ���������������������������򲻻��������
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
				System.out.println(name+"��Ϳ�ں�");
				Thread.sleep(1000);
				
//				synchronized (mirror) {
//				  System.out.println(name+"1���ȥ�þ���");
//				}
			}
		}else {
			synchronized(mirror) {
				System.out.println(name+"���þ���");
				Thread.sleep(2000);
				System.out.println(name+"2���ȥͿ�ں�");

//				synchronized (lipstick) {
//				  System.out.println(name+"2���ȥͿ�ں�");
//				}
			}
		}
	}
}
class Lipstick{
	
}
class Mirror{
	
}
