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
 *  从磁盘读取一个文件到内存中，再打印到控制台
 * @author chu_c
 *
 */
public class Test_04 {
	
	/**
	 * 读文件
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
				
				//*********字符流**********
				/**
				 * public void mark(int readAheadLimit)
				          throws IOException标记流中的当前位置。 对reset（）的后续调用将尝试将流重新定位到此位置。 
				     
			       		：***注意***
			       	Reader方法中有mark这个方法,是对流中读取位置的标志，说明java中还是有指针这个概念的 
			       	reader每执行一次read、reader（char[],off,len）、readline方法都会使指针进行位移，可以使用reset方法将指针调制想要的位置
			       	默认是初始化位置（从头开始）
				          
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
//					System.out.println(br.readLine());//先当前行读再跳下一个字符  一气呵成
					System.out.println(read);//
					bufferedWriter.write(read);
					bufferedWriter.newLine();//由于.write(read);只是写了一行数据，并不进行文件的分行操作，所有增加这个方法进行文件的下一行书写
					bufferedWriter.flush();
				}
				
				System.out.println("******");
				bufferedWriter.close();
				
				br.close();
				isr.close();
				//*********字节流**********
				while( (len = fis.read(b)) != -1) {
					
					//将文件内容写到内存中
					sbf.append(new String(b,0,len));
					//将内存中的文件内容写到 io文件中
					fos.write(b, 0, len);
					fos.flush();
				}
				fos.close();
				//将内存中的文件内容写到控制台中
				System.out.println(sbf.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

	public static void main(String[] args) {
		Test_04 test_04 = new Test_04();
		File file = new File("D:\\workspaces\\distribution\\daliytest\\src\\main\\java\\com\\cjean\\daliytest\\IO\\Test_04.java");
		System.out.println("开始");
		test_04.readFile(file);
		System.out.println("结束");
	}

}
