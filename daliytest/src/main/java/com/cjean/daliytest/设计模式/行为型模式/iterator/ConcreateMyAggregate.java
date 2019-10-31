package com.cjean.daliytest.设计模式.行为型模式.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义一个聚合类
 * 	将数据存放在聚合类中
 * 	并在聚合类中创建 本聚合类特有的迭代器对象方法
 * @author Cjean
 *
 */
public class ConcreateMyAggregate {
	private List<Object> list = new ArrayList<>();
	
	public void add(Object obj) {
		list.add(obj);
	}
	public void remove(Object obj) {
		list.remove(obj);
	}
	// 方便对数据操作 创建set get 方法
	public List<Object> getList() {
		return list;
	}
	public void setList(List<Object> list) {
		this.list = list;
	}
	// 创建特有的迭代器
	public Myiterator createMyIterator() {
		return new CreateIterator();
	}
	
	// 创建迭代器内部类   方便使用
	public class CreateIterator implements Myiterator{
		
		private int curos;// 游标
		@Override
		public boolean isFirst() {
			return curos == 0;
		}

		@Override
		public boolean isLast() {
			// TODO Auto-generated method stub
			return curos == (list.size()-1);
		}

		@Override
		public boolean hasNext() {
			if(curos < list.size()) {
				return true;
			}
			return false;
		}

		@Override
		public void first() {
			curos = 0;
		}

		@Override
		public void last() {
			curos = (list.size()-1);
			
		}

		@Override
		public Object getCurrentObj() {
			return list.get(curos);
		}

		@Override
		public void next() {
			curos++;			
		}
		
	}
	
}
