package com.cjean.daliytest.algorithm;

import com.cjean.daliytest.util.StringUtil;
import com.cjean.daliytest.util.StringArrUtil;

/**
 * 二分法查找
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
				return"查到"+searchStr+"，在数组的第"+(len+1)+"位置。";
			}
			
			int index = 0;
			while(true) {
				if(index < len) {
					if(searchStr.equals(args[index])) {
						return"查到"+searchStr+"，在数组的第"+(index+1)+"位置。";
					}
					index++;
				}
				else if(index > len) {
					if(searchStr.equals(args[index])) {
						return"查到"+searchStr+"，在数组的第"+(index+1)+"位置。";
					}
					index++;
				}
				else {
					return "搜索关键字："+searchStr+"，在数组中不存在。";
				}
			}
		}
		return "搜索关键字："+searchStr+"，在数组中不存在。";
	}
	public static void main(String[] args) {
//		String[] args1 = {"12","134","15","61","81","88"};
		String[] args1 = {"12","134","15","1","61","81","88"};
		System.out.println(biSearcher(args1,"1"));
	}

}
