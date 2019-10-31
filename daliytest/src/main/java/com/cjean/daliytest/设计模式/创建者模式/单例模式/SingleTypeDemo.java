package com.cjean.daliytest.���ģʽ.������ģʽ.����ģʽ;
/**
 * ���� ����ʽ�� ����ģʽ
 * @author Cjean
 *
 */
public class SingleTypeDemo {
	//�����ǵ���  ���ⲻ��new���� 
	private static volatile SingleTypeDemo instance;
	//1.˽�л�������
	private SingleTypeDemo() {
		
	}
	//2.�����ṩ ��̬����
	public static SingleTypeDemo getInstance() {
		// ���ڻ���� ���÷�����ʱ���� ���Զ� ʵ��������� �ж�
		if(null != instance) {
			return instance;
		}else {
			// Ϊ��ֹ���̲߳������� ����Դ������м���
			synchronized(SingleTypeDemo.class) {
				if(null == instance) {
					return instance = new SingleTypeDemo();
				}
			}
		}
		return instance;
	}
	

	public static void main(String[] args) {

		for (int i = 0; i < 50; i++) {
			new Thread(() -> {
				System.out.println(SingleTypeDemo.getInstance());
			}).start();
			try {
				Thread.sleep(2000);
				System.out.println("2000000");
				System.out.println(SingleTypeDemo.getInstance());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.err.println("-------------------");
		}
		
	}

}
