package com.cjean.daliytest.IO;

import java.io.File;

/**
 * �ݹ�ʵ����������Ŀ¼���г��ļ��Լ��ļ��У�Ч����ͼ
 * @author chu_c
 *
 */
public class TestIO_02 {
	
	/**
	 * ����һ��·��  ���ʱ�ļ���չʾ�ļ���  ������ļ��о�չʾ�ļ��������е��ļ���
	 * ���ļ����е�����  �����ļ��Լ��ļ���   ���õݹ��ѯ
	 * @param file
	 */
	public void showDir(File file) {
		if(file.isFile()) {
			System.out.println("�ļ���"+file.getPath()+"--"+file.getName());
		}
		else {//������ļ���  �ݹ��ѯ
			System.out.println("�ļ��У�"+file.getPath()+"--"+file.getName());
			File[] listFiles = file.listFiles();//��ѯ�ļ��������е��ļ�
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
