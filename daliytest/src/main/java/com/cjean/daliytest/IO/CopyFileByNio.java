package com.cjean.daliytest.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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

    //基于NIO实现文件拷贝
    public static void copyFileNIO(String resource, String target) {
        try(FileInputStream fis = new FileInputStream(resource);FileOutputStream fos = new FileOutputStream(target)){
            FileChannel fisChannel = fis.getChannel();
            FileChannel fosChannel = fos.getChannel();

            ByteBuffer allocate = ByteBuffer.allocate(10240);

            while ((fisChannel.read(allocate))!=-1){
                allocate.flip();
                fosChannel.write(allocate);
                allocate.clear();
            }
        }catch (Exception e){
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
        copyFileNIO(resource, target);
        //  copyFileComm(resource,target);

    }
}
