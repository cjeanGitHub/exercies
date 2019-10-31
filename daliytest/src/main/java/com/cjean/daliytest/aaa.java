package com.cjean.daliytest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class aaa {

	public static void main(String[] args) {
		
		new HashSet();
		
		new TreeSet();
		
		new LinkedHashSet();
		
		new HashMap();
		
		Pattern pattern = Pattern.compile("\\d{6}");
		boolean matches = pattern.matcher("121109").matches();
		System.out.println(matches);
	}

}
