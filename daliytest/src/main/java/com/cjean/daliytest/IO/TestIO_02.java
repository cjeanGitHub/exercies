package com.cjean.daliytest.IO;

import java.io.File;

/**
 * 递归实现输入任意目录，列出文件以及文件夹，效果看图
 * @author chu_c
 *
 */
public class TestIO_02 {
	
	/**
	 * 输入一个路径  如果时文件就展示文件名  如果是文件夹就展示文件夹中所有的文件名
	 * 读文件夹中的内容  包含文件以及文件夹   利用递归查询
	 * @param file
	 */
	public void showDir(File file) {
		if(file.isFile()) {
			System.out.println("文件："+file.getPath()+"--"+file.getName());
		}
		else {//如果是文件夹  递归查询
			System.out.println("文件夹："+file.getPath()+"--"+file.getName());
			File[] listFiles = file.listFiles();//查询文件夹中所有的文件
			for (File file2 : listFiles) {
				showDir(file2);
			}
		}
	}

	public static void main(String[] args) {
		TestIO_02 testIO_02 = new TestIO_02();
//		File file2 = new File("D://IOTest"); //D:\\workspaces\\distribution\\lucene\\src\\com
		File file2 = new File("D://workspaces//distribution//lucene//src//com");
		testIO_02.showDir(file2);
	}

}
