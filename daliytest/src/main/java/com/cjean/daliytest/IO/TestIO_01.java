package com.cjean.daliytest.IO;

import java.io.File;
import java.io.IOException;

public class TestIO_01 {
	/**
     * 1. �ڵ���D���´���һ���ļ�ΪHelloWorld.txt�ļ���
     * �ж������ļ�����Ŀ¼���ٴ���һ��Ŀ¼IOTest,
     * ֮��HelloWorld.txt�ƶ���IOTestĿ¼��ȥ��
     * ֮�����IOTest���Ŀ¼�µ��ļ�
     *
     * ���������
     * 1���ļ�����ʹ��File��createNewFile()����
     * 2���ж����ļ���isFile(),�ж���Ŀ¼��isDirectory
     * 3������Ŀ¼�ã�mkdirs()����
     * 4���ƶ��ļ��ã�renameTo
     * 5������Ŀ¼�ã�list����������ô���ļ������飬foreach�����ķ������ļ���ӡ����
     * */
	public static void main(String[] args) {
		File file1 = new File("D://HelloWorld.txt");
		File file2 = new File("D://IOTest");
		try {
			// ����Ѿ����ھ�ɾ��
			if(file1.exists()) {
				file1.delete();
			}
			boolean createNewFile = file1.createNewFile();
			if(createNewFile) {
				System.out.println("�����ļ��ɹ�...");
			}
			else {
				System.out.println("�����ļ�ʧ��...");
			}
			
			// file���Զ������ļ����𣿣�   ������
			//��Ȼ�ǲ��еİ�  �������Լ�����
			
			// ����Ѿ����ھ�ɾ��
			if(file2.exists()) {
				file2.delete();
			}
			
			file2.mkdir();
			if(file2.isDirectory()) {
				System.out.println("�����ļ��гɹ�...");
				
				//ʹ��renameto���ﵽ�ƶ��ļ��е�Ҫ��
				File file3 = new File("D://IOTest//removeHelloWorld.txt");
				// ����Ѿ����ھ�ɾ��
				
				boolean renameTo = file1.renameTo(file3);
				if(renameTo) {
					System.out.println("�ƶ��ļ��ɹ�...");
				}
				else {
					System.out.println("�ƶ��ļ�ʧ��...");
				}
				//����IOtest�ļ����� ���ļ�
				File[] listFiles = file2.listFiles();
				for (File file : listFiles) {
					if(file.isFile()) {
						System.out.println("�ļ���"+file.getName());
					}else {
						System.out.println("�ļ��У�"+file.getName());
					}
				}
			}
			else {
				System.out.println("�����ļ���ʧ��...");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
		}

	}

}
