package com.cjean.daliytest.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *  �Ӵ��̶�ȡһ���ļ����ڴ��У��ٴ�ӡ������̨
 * @author chu_c
 *
 */
public class Test_04 {
	
	/**
	 * ���ļ�
	 * @param file
	 */
	@SuppressWarnings("resource")
	public void readFile(File file) {
		
		if(file.isFile()) {
			try(FileInputStream fis = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
				) {
				int length = (int)file.length();
				byte[] b = new byte[length];
				int len = 0;
				StringBuffer sbf = new StringBuffer();
				
				System.out.println(file.getParent()+"\\copyFile.txt");
				File copyFile = new File(file.getParent()+"\\copyFile.txt");
				File copyFile2 = new File(file.getParent()+"\\copyFile2.txt");
				FileOutputStream fos = new FileOutputStream(copyFile);
				
				//*********�ַ���**********
				/**
				 * public void mark(int readAheadLimit)
				          throws IOException������еĵ�ǰλ�á� ��reset�����ĺ������ý����Խ������¶�λ����λ�á� 
				     
			       		��***ע��***
			       	Reader��������mark�������,�Ƕ����ж�ȡλ�õı�־��˵��java�л�����ָ���������� 
			       	readerÿִ��һ��read��reader��char[],off,len����readline��������ʹָ�����λ�ƣ�����ʹ��reset������ָ�������Ҫ��λ��
			       	Ĭ���ǳ�ʼ��λ�ã���ͷ��ʼ��
				          
				 */
				
				
				BufferedReader br = new BufferedReader(isr);
				BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(copyFile2)));
//				br.mark(0);
//				System.out.println(br.read());
//				System.out.println((char) br.read());
				System.out.println("******");
				String read;
				
//				br.reset();
				while((read = br.readLine())!= null) {
//					System.out.println(br.readLine());//�ȵ�ǰ�ж�������һ���ַ�  һ���ǳ�
					System.out.println(read);//
					bufferedWriter.write(read);
					bufferedWriter.newLine();//����.write(read);ֻ��д��һ�����ݣ����������ļ��ķ��в�������������������������ļ�����һ����д
					bufferedWriter.flush();
				}
				
				System.out.println("******");
				bufferedWriter.close();
				
				br.close();
				isr.close();
				//*********�ֽ���**********
				while( (len = fis.read(b)) != -1) {
					
					//���ļ�����д���ڴ���
					sbf.append(new String(b,0,len));
					//���ڴ��е��ļ�����д�� io�ļ���
					fos.write(b, 0, len);
					fos.flush();
				}
				fos.close();
				//���ڴ��е��ļ�����д������̨��
				System.out.println(sbf.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

	public static void main(String[] args) {
		Test_04 test_04 = new Test_04();
		File file = new File("D:\\workspaces\\distribution\\daliytest\\src\\main\\java\\com\\cjean\\daliytest\\IO\\Test_04.java");
		System.out.println("��ʼ");
		test_04.readFile(file);
		System.out.println("����");
	}

}