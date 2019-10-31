package com.cjean.daliytest.ÈÝÆ÷;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestCollection {

	public static void main(String[] args) {
		List<String> s1 = new ArrayList<String>();
		s1.add("1111");
		s1.add("2222");
		s1.add("3333");
		s1.add("4444");
		List<String> s2 = new ArrayList<String>();
		s2.add("1111");
		s2.add("2222");
		s2.add("5555");
		s2.add("6666");
		
	//	s1.retainAll(s2);
		
		List<String> s3 = new ArrayList<String>();
		s3.addAll(s1);
		System.out.println(s3);
		s2.removeAll(s1);

		System.out.println(s2);
		s3.addAll(s2);
		
		
		System.out.println(s1.toArray());
		System.out.println(s1);
		System.out.println(s3);
		
		Set<String> s = new HashSet<String>();
		
		
	}

}
