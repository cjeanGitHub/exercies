package com.cjean.daliytest.设计模式.结构型模式.bridge;
/**|
 * 这种继承关系，会出现文档中所说的 一个类会受2个维度的因素影响
 * 	所以可以借助 桥接（bridge）模式，进行维度分离，实现
 * 一个类只受一个因素影响，实现类的单一职责原则
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
		System.out.println("销售联想台式机");
	}
		
}
class LevonoLaptop implements Computer{
	@Override
	public void sale() {
		System.out.println("销售联想笔记本");
	}
	
}
class LevonoPad implements Computer{
	@Override
	public void sale() {
		System.out.println("销售联想Pad");
	}
	
}
class DellDesktop implements Computer{
	@Override
	public void sale() {
		System.out.println("销售戴尔台式机");
	}
		
}
class DellLaptop implements Computer{
	@Override
	public void sale() {
		System.out.println("销售戴尔笔记本");
	}
	
}
class DellPad implements Computer{
	@Override
	public void sale() {
		System.out.println("销售戴尔Pad");
	}
	
}
class ShenzhouDesktop implements Computer{
	@Override
	public void sale() {
		System.out.println("销售神州台式机");
	}
		
}
class ShenzhouLaptop implements Computer{
	@Override
	public void sale() {
		System.out.println("销售神州笔记本");
	}
	
}
class ShenzhouPad implements Computer{
	@Override
	public void sale() {
		System.out.println("销售神州Pad");
	}
	
}