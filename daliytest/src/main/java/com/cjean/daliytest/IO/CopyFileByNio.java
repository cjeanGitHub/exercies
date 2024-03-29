package com.cjean.daliytest.IO;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName:CopyFileByNio
 * @Description:
 * @author: chu_c
 * @date: 2019-11-05
 */
//D:\HelloWorld.txt
public class CopyFileByNio {
    public CopyFileByNio() {
        new AssertionError();
    }

    //输出 字符串在文件内容中存在的数量
    public static void printWordInFile(String resource, String word) {
        try(FileInputStream fis = new FileInputStream(resource);) {
            int len = 0 ;
            byte[] bytes = new byte[1024*8];
            StringBuilder sb = new StringBuilder();

            while ((len = fis.read(bytes))!=-1){
                sb.append(new String(bytes,0,len));
            }
            String[] strings = sb.toString().split(word);
            System.out.println("======"+(strings.length-1)+"========");

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //打印到控制台
    public static void printConconsle() {
        try {
            byte[] bytes = new byte[10240];
            int len = 0;
            StringBuilder sb = new StringBuilder();

            String string = "000";
            while ("888" != string) {
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);
                string = br.readLine();
                if (string.equals("888")) break;
                System.out.println("======" + string + "========");
            }


//            while ((len = System.in.read(bytes))!= -1){
//                sb.append(new String(bytes,0,len));
//                System.out.println("===11==="+sb.toString()+"========");
//                if (sb.toString().contains("88")) break;
//            }
            System.out.println("======" + sb.toString() + "========");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //基于NIO实现文件拷贝
    public static void copyFileNIO(String resource, String target) {
        try (FileInputStream fis = new FileInputStream(resource); FileOutputStream fos = new FileOutputStream(target)) {
            FileChannel fisChannel = fis.getChannel();
            FileChannel fosChannel = fos.getChannel();

            ByteBuffer allocate = ByteBuffer.allocate(10240);

            while ((fisChannel.read(allocate)) != -1) {
                allocate.flip();
                fosChannel.write(allocate);
                allocate.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //普通的文件拷贝
    public static void copyFileComm(String resource, String target) {
        try (FileInputStream fis = new FileInputStream(resource); FileOutputStream fos = new FileOutputStream(target)) {
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
            System.out.println("==============");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String resource = "D:\\HelloWorld.txt";
        String target = "D:\\HelloWorld2.txt";

        printWordInFile("D:\\hhh.txt","你好啊");
//        copyFileNIO(resource, target);
        //  copyFileComm(resource,target);

    }
}
