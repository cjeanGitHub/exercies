package com.cjean.daliytest.util;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.*;

/**
 * @ClassName:CloneUtil
 * @Description:
 * @author: chu_c
 * @date: 2019-11-05
 */

public class CloneUtil {
    public CloneUtil(){
        new AssertionError();
    }
    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T clone(T obj) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        System.out.println("===bout:==="+bout.toByteArray().toString()+"========");

        ObjectOutputStream oout = new ObjectOutputStream(bout);
        System.out.println("===bout:=oout=="+bout.toByteArray()+"========");

        oout.writeObject(obj);
        System.out.println("===bout:=oout=writeObject="+bout.toByteArray()+"========");

        ByteArrayInputStream bis = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);

        return (T) ois.readObject();
    }

}
