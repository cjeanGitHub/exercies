package com.cjean.daliytest.设计模式.行为型模式.iterator;

import com.cjean.daliytest.设计模式.行为型模式.iterator.ConcreateMyAggregate.CreateIterator;

public class Client {

	public static void main(String[] args) {
		ConcreateMyAggregate c1 = new ConcreateMyAggregate();
		c1.add("aa");
		c1.add("bb");
		c1.add("cc");
		
		Myiterator myiterator = c1.createMyIterator();
		while(myiterator.hasNext()) {
			System.out.println("myiterator.isFirst():"+myiterator.isFirst());
			System.out.println("myiterator.isLast():"+myiterator.isLast());
			System.out.println("myiterator.getCurrentObj():"+myiterator.getCurrentObj());
			myiterator.next();
			System.out.println("myiterator.hasNext():"+myiterator.hasNext());
			System.out.println("############################");
		}
		
		
	}

}
