package com.cjean.webcrawler.bcrawler;

import java.util.HashMap;

public class ssssss_2 {
      public static void main(String[] a){
          HashMap<Integer, String> map = new HashMap<>();

          map.put(0, "a");
          String b = map.put(0, "b");

          map.put(1, "a");
          map.put(2, "a");
          map.put(3, "a");


//          String a1 = map.putIfAbsent(0,"c");
          String s = map.get(0);
          System.out.println("map:"+s);
//          System.out.println(a1);
          System.out.println("bmap:"+b);


      }
}