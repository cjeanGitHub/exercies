package com.cjean.daliytest.设计模式.行为型模式.mediator;
/**
 *   部门间 命令传递的中介
 *   	开发部门  财务部门  市场部门   三个部门之间相互调用  通过 总经理  来实现命令转发   总经理实现中介接口
 *   
 *   命令下发方法
 *   部门注册方法
 * @author Cjean
 *
 */
public interface Mediator {
	void command(String dname);
	
	 void register(String dname, Department department);
}
