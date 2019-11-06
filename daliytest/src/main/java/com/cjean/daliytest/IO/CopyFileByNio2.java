package com.cjean.daliytest.IO;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

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
public class CopyFileByNio2 {
    public CopyFileByNio2() {
        new AssertionError();
    }

    //打印到控制台
    public static void printConconsle() {


        try {
            byte[] bytes = new byte[10240];
            int len = 0;
            StringBuilder sb = new StringBuilder();

            String string ="000";
            while ("888" != string){
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);
                string = br.readLine();
                if (string.equals("888")) break;
                System.out.println("======"+string+"========");
            }


//            while ((len = System.in.read(bytes))!= -1){
//                sb.append(new String(bytes,0,len));
//                System.out.println("===11==="+sb.toString()+"========");
//                if (sb.toString().contains("88")) break;
//            }
            System.out.println("======"+sb.toString()+"========");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //使用NIO实现文件复制
    public static void copyByNIO(String resource, String target) {
        try(FileInputStream fis = new FileInputStream(resource);FileOutputStream fos = new FileOutputStream(target);) {
            FileChannel fisChannel = fis.getChannel();
            FileChannel fosChannel = fos.getChannel();

            ByteBuffer allocate = ByteBuffer.allocate(10240);

            while ((fisChannel.read(allocate)) != -1){
                allocate.flip();
                fosChannel.write(allocate);
                allocate.clear();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //使用传统字节流实现文件的复制
    public static void copyByComm(String resource, String target) {
        try (FileInputStream fis = new FileInputStream(resource); FileOutputStream fos = new FileOutputStream(target);) {
            byte[] bytes = new byte[10240];
            int len = 0;
            StringBuilder sb = new StringBuilder();
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

        printConconsle();
//        copyByNIO(resource,target);
//        copyByComm(resource,target);
    }
}
