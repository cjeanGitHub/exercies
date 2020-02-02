package com.cjean.webcrawler.bcrawler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ssssss {
      public static void main(String[] a){
            try {
//                String urlStr = "https://wwwapi.kugou.com/yy/index.php?r=play/getdata&callback=jQuery191027067069941080546_1546235744250&hash=0BCD762E2FA1984818B3CCCDB16A5424&album_id=0&_=1576758970818";

                URL url=new URL("http://www.baidu.com");
//                URL url=new URL(urlStr);
                BufferedReader reader=new BufferedReader(new InputStreamReader(url.openStream()));
                BufferedWriter writer=new BufferedWriter(new FileWriter("index.html"));
                String line;
                while((line=reader.readLine())!=null){
                    System.out.println(line);
                    writer.write(line);
                    writer.newLine();
                }
                reader.close();
                writer.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
}