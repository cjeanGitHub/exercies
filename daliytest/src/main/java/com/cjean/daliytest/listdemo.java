package com.cjean.daliytest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class listdemo {
	public static void main(String[] args) {
		List<String> a = new ArrayList();
		List<String> b = new ArrayList();
		a.add("a");
		a.add("a");
		a.add("b");
		a.add("c");
		a.add("c");
		
		System.out.println(a.toString());
		
		Set s = new HashSet();
		s.addAll(a);
		
		System.out.println(s.toString());
		if(a.contains("a")) {
			a.remove("a");
		}
		
		if(s.contains("c")) {
			s.remove("c");
		}
		
		b.addAll(s);
		System.out.println("b===="+b.toString());
		
		System.out.println("a===="+a.toString());
		
	}

	public void testSamle() {
		// ע�⣺һ��Ҫʹ�ô�������ĸ�ʽ��������
		Integer[] a = new Integer[] { 6, 3, 9, 3, 2, 4, 5, 7 };
		Integer[] b = new Integer[] { 5, 8, 6, 2, 1, 9 };
		List _a = Arrays.asList(a);
		List _b = Arrays.asList(b);
		// ��������
		Collection realA = new ArrayList<Integer>(_a);
		Collection realB = new ArrayList<Integer>(_b);
		// �󽻼�
		realA.retainAll(realB);
		System.out.println("���������" + realA);
		Set result = new HashSet();
		// ��ȫ��
		result.addAll(_a);
		result.addAll(_b);
		System.out.println("ȫ�������" + result);
		// �������
		Collection aa = new ArrayList(realA);
		Collection bb = new ArrayList(result);
		bb.removeAll(aa);
		List<String> cc = new ArrayList<>(bb);
		System.out.println("���ս����" + bb);
	}
}
