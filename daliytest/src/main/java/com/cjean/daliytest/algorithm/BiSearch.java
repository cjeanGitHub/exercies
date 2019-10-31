package com.cjean.daliytest.algorithm;

import com.cjean.daliytest.util.StringUtil;
import com.cjean.daliytest.util.StringArrUtil;

/**
 * ���ַ�����
 * @author chu_c
 *
 */
public class BiSearch {
	
	public static String biSearcher(String[] args,String searchStr) {
		StringUtil stringUtil = new StringUtil();
		StringArrUtil stringArrUtil = new StringArrUtil();
		
		if(stringArrUtil.isNotEmpty(args) && stringUtil.isNotEmpty(searchStr)) {
			int len = args.length-1;
			if(searchStr.equals(args[len])) {
				return"�鵽"+searchStr+"��������ĵ�"+(len+1)+"λ�á�";
			}
			
			int index = 0;
			while(true) {
				if(index < len) {
					if(searchStr.equals(args[index])) {
						return"�鵽"+searchStr+"��������ĵ�"+(index+1)+"λ�á�";
					}
					index++;
				}
				else if(index > len) {
					if(searchStr.equals(args[index])) {
						return"�鵽"+searchStr+"��������ĵ�"+(index+1)+"λ�á�";
					}
					index++;
				}
				else {
					return "�����ؼ��֣�"+searchStr+"���������в����ڡ�";
				}
			}
		}
		return "�����ؼ��֣�"+searchStr+"���������в����ڡ�";
	}
	public static void main(String[] args) {
//		String[] args1 = {"12","134","15","61","81","88"};
		String[] args1 = {"12","134","15","1","61","81","88"};
		System.out.println(biSearcher(args1,"1"));
	}

}
