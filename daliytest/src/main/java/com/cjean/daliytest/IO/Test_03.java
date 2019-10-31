package com.cjean.daliytest.IO;

import java.io.File;

/**
 * 递归实现列出当前工程下所有.java文件
 * @author chu_c
 *
 */
public class Test_03 {
	
	public void showFileBySuffix(File file) {
		//如果是文件  直接打印出文件路径
		if(file.isFile()) {
			if(file.getName().endsWith(".java")) {
				System.out.println("java文件："+file.getPath());
			}
		}
		else {
			//如果是文件夹  遍历文件夹中的目录并打印出本文件夹中的java文件 
			File[] listFiles = file.listFiles();
			if(listFiles.length>0) {
				for (File file2 : listFiles) {
					showFileBySuffix(file2);
				}
			}
		}
	}
	public static void main(String[] args) {
		Test_03 test_03 = new Test_03();
		File file = new File("D:\\workspaces\\distribution");
		if(file.exists()) {
			System.out.println("*******");
		}
		
		test_03.showFileBySuffix(file);
	}

}
