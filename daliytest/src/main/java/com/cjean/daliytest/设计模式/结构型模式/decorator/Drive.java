package com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.decorator;

/**
 * �������
 * @author Cjean
 *
 */
public interface Drive {
	void mes();
}
/**
 * ��ʵ���
 * @author Cjean
 *
 */
class Car implements Drive{

	@Override
	public void mes() {
		System.out.println("һ��ĳ������ӹ��ܣ�");
	}
	
}

/**
 * ����װ��
 * @author Cjean
 *
 */
abstract class Decorate implements Drive{
	private Drive drive;
	public Decorate(Drive drive) {
		super();
		this.drive = drive;
	}
	@Override
	public void mes() {
		drive.mes();
	}
	
}

/**
 * ��ʵװ��
 * @author Cjean
 *
 */
class WaterCar extends Decorate{

	public WaterCar(Drive drive) {
		super(drive);
	}

	@Override
	public void mes() {
		// TODO Auto-generated method stub
		System.out.println(swiming());
	}
	
	String swiming() {
		super.mes();
		return "Ǳˮ����";
	}
	
}
/**
 * ��ʵװ��
 * @author Cjean
 *
 */
class FlyCar extends Decorate{

	public FlyCar(Drive drive) {
		super(drive);
	}

	@Override
	public void mes() {
		// TODO Auto-generated method stub
		super.mes();
		System.out.println("--"+swiming());
	}
	
	String swiming() {
		return "���й���";
	}
	
}

