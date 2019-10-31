package com.cjean.daliytest.���ģʽ.��Ϊ��ģʽ.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * �Զ���һ���ۺ���
 * 	�����ݴ���ھۺ�����
 * 	���ھۺ����д��� ���ۺ������еĵ��������󷽷�
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
	// ��������ݲ��� ����set get ����
	public List<Object> getList() {
		return list;
	}
	public void setList(List<Object> list) {
		this.list = list;
	}
	// �������еĵ�����
	public Myiterator createMyIterator() {
		return new CreateIterator();
	}
	
	// �����������ڲ���   ����ʹ��
	public class CreateIterator implements Myiterator{
		
		private int curos;// �α�
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
