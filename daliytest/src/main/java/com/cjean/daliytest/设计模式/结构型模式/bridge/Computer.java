package com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.bridge;
/**|
 * ���ּ̳й�ϵ��������ĵ�����˵�� һ�������2��ά�ȵ�����Ӱ��
 * 	���Կ��Խ��� �Žӣ�bridge��ģʽ������ά�ȷ��룬ʵ��
 * һ����ֻ��һ������Ӱ�죬ʵ����ĵ�һְ��ԭ��
 * 	
 * @author Cjean
 *
 */

public interface Computer {
	void sale();
}

class LevonoDesktop implements Computer{
	@Override
	public void sale() {
		System.out.println("��������̨ʽ��");
	}
		
}
class LevonoLaptop implements Computer{
	@Override
	public void sale() {
		System.out.println("��������ʼǱ�");
	}
	
}
class LevonoPad implements Computer{
	@Override
	public void sale() {
		System.out.println("��������Pad");
	}
	
}
class DellDesktop implements Computer{
	@Override
	public void sale() {
		System.out.println("���۴���̨ʽ��");
	}
		
}
class DellLaptop implements Computer{
	@Override
	public void sale() {
		System.out.println("���۴����ʼǱ�");
	}
	
}
class DellPad implements Computer{
	@Override
	public void sale() {
		System.out.println("���۴���Pad");
	}
	
}
class ShenzhouDesktop implements Computer{
	@Override
	public void sale() {
		System.out.println("��������̨ʽ��");
	}
		
}
class ShenzhouLaptop implements Computer{
	@Override
	public void sale() {
		System.out.println("�������ݱʼǱ�");
	}
	
}
class ShenzhouPad implements Computer{
	@Override
	public void sale() {
		System.out.println("��������Pad");
	}
	
}