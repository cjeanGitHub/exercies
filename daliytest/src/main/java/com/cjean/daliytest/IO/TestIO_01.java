package com.cjean.daliytest.IO;

import java.io.File;
import java.io.IOException;

public class TestIO_01 {
	/**
     * 1. 在电脑D盘下创建一个文件为HelloWorld.txt文件，
     * 判断他是文件还是目录，再创建一个目录IOTest,
     * 之后将HelloWorld.txt移动到IOTest目录下去；
     * 之后遍历IOTest这个目录下的文件
     *
     * 程序分析：
     * 1、文件创建使用File的createNewFile()方法
     * 2、判断是文件用isFile(),判断是目录用isDirectory
     * 3、创建目录用：mkdirs()方法
     * 4、移动文件用：renameTo
     * 5、遍历目录用：list（）方法获得存放文件的数组，foreach遍历的方法把文件打印出来
     * */
	public static void main(String[] args) {
		File file1 = new File("D://HelloWorld.txt");
		File file2 = new File("D://IOTest");
		try {
			// 如果已经存在就删除
			if(file1.exists()) {
				file1.delete();
			}
			boolean createNewFile = file1.createNewFile();
			if(createNewFile) {
				System.out.println("创建文件成功...");
			}
			else {
				System.out.println("创建文件失败...");
			}
			
			// file会自动创建文件夹吗？？   忘记了
			//显然是不行的啊  还是我自己来吧
			
			// 如果已经存在就删除
			if(file2.exists()) {
				file2.delete();
			}
			
			file2.mkdir();
			if(file2.isDirectory()) {
				System.out.println("创建文件夹成功...");
				
				//使用renameto来达到移动文件夹的要求
				File file3 = new File("D://IOTest//removeHelloWorld.txt");
				// 如果已经存在就删除
				
				boolean renameTo = file1.renameTo(file3);
				if(renameTo) {
					System.out.println("移动文件成功...");
				}
				else {
					System.out.println("移动文件失败...");
				}
				//遍历IOtest文件夹内 的文件
				File[] listFiles = file2.listFiles();
				for (File file : listFiles) {
					if(file.isFile()) {
						System.out.println("文件："+file.getName());
					}else {
						System.out.println("文件夹："+file.getName());
					}
				}
			}
			else {
				System.out.println("创建文件夹失败...");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
		}

	}

}
