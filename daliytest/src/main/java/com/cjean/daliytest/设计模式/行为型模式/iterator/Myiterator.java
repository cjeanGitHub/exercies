package com.cjean.daliytest.设计模式.行为型模式.iterator;
/**
 * 创建迭代器 接口
 * @author Cjean
 *
 */
public interface Myiterator {
	boolean isFirst();// 是不是第一个
	
	boolean isLast();// 是不是最后一个
	
	boolean hasNext();// 是不是还有下一个
	
	void first();// 第一个
	
	void last();// 最后一个
	
	Object getCurrentObj();// 获取当前游标下的数据

	void next();// 下一个游标一个
}
