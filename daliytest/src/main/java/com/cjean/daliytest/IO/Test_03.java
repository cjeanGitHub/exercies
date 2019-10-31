package com.cjean.daliytest.IO;

import java.io.File;

/**
 * �ݹ�ʵ���г���ǰ����������.java�ļ�
 * @author chu_c
 *
 */
public class Test_03 {
	
	public void showFileBySuffix(File file) {
		//������ļ�  ֱ�Ӵ�ӡ���ļ�·��
		if(file.isFile()) {
			if(file.getName().endsWith(".java")) {
				System.out.println("java�ļ���"+file.getPath());
			}
		}
		else {
			//������ļ���  �����ļ����е�Ŀ¼����ӡ�����ļ����е�java�ļ� 
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
