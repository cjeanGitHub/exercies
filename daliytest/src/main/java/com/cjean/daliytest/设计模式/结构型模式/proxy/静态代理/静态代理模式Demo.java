package com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.proxy.��̬����;

/**
 *��̬���� ģʽ ���̳У�extends�����ۺϣ�implements����  3����
 * 
 * 1.����ӿڣ���ǿ��Ķ���
 * 2.��ʵ��ɫ������ǿ�Ķ���
 * 3.�����ɫ
 * 
 * @author Cjean
 *
 */
public class ��̬����ģʽDemo {
	public static void main(String[] args) {
		
		new MarryCompany(new You()).happyMarry();
	}
}
//����ӿ�
interface HappyMarry{
	void happyMarry();
}
//��ʵ��ɫ
class You implements HappyMarry{
	public void happyMarry() {
		System.out.println("�������飡��");
	}
}

//�����ɫ
class MarryCompany implements HappyMarry{
	private You you;

	public MarryCompany(You you) {
		super();
		this.you = you;
	}
	public MarryCompany() {
		
		// TODO Auto-generated constructor stub
	}
	public void happyMarry() {
		you.happyMarry();
		after();
	}
	
	void after() {
		System.out.println("����˾�ܰ�������");
	}
	
}


