package com.bing.download;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * @说明：
 * @author: gaoll
 * @CreateTime:2014-11-20
 * @ModifyTime:2014-11-20
 */
public class FileDownload {

    /**
     * 文件下载
     * @param url 链接地址
     * @param path 要保存的路径及文件名
     * @return
     */
    public static boolean download(String url,String path){

        boolean flag = false;

        CloseableHttpClient httpclient = HttpClients.createDefault();
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000)
                .setConnectTimeout(2000).build();

        HttpGet get = new HttpGet(url);
        get.setConfig(requestConfig);

        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        try{
            for(int i=0;i<3;i++){
                CloseableHttpResponse result = httpclient.execute(get);
                System.out.println(result.getStatusLine());
                if(result.getStatusLine().getStatusCode() == 200){
                    in = new BufferedInputStream(result.getEntity().getContent());
                    File file = new File(path);
                    out = new BufferedOutputStream(new FileOutputStream(file));
                    byte[] buffer = new byte[1024];
                    int len = -1;
                    while((len = in.read(buffer,0,1024)) > -1){
                        out.write(buffer,0,len);
                    }
                    flag = true;
                    break;
                }else if(result.getStatusLine().getStatusCode() == 500){
                    continue ;
                }
            }

        }catch(Exception e){
            e.printStackTrace();
            flag = false;
        }finally{
            get.releaseConnection();
            try{
                if(in != null){
                    in.close();
                }
                if(out != null){
                    out.close();
                }
            }catch(Exception e){
                e.printStackTrace();
                flag = false;
            }
        }
        return flag;
    }

    private static Log log = LogFactory.getLog(FileDownload.class);

    public static void main(String[] args) {
        download("https://webfs.yun.kugou.com//201912191716//8541c2619729ecdaee22f513f57c9b14//G173//M07//18//19//7Q0DAF3vQHCAba7HADarweFad6I342.mp3","F:/music/123.mp3");
    }
}