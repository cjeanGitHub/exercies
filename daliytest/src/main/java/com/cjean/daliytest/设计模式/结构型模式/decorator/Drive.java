package com.cjean.daliytest.设计模式.结构型模式.decorator;

/**
 * 抽象组件
 * @author Cjean
 *
 */
public interface Drive {
	void mes();
}
/**
 * 真实组件
 * @author Cjean
 *
 */
class Car implements Drive{

	@Override
	public void mes() {
		System.out.println("一般的车，增加功能：");
	}
	
}

/**
 * 抽象装饰
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
 * 真实装饰
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
		return "潜水功能";
	}
	
}
/**
 * 真实装饰
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
		return "飞行功能";
	}
	
}

