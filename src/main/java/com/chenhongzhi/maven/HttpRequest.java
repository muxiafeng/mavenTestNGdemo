package com.chenhongzhi.maven;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import jdk.nashorn.api.scripting.ScriptUtils;
import jdk.nashorn.internal.runtime.JSONFunctions;
import jdk.nashorn.internal.runtime.JSONListAdapter;
import org.apache.http.Header;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;

import java.io.IOException;
import java.security.Key;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HttpRequest {
    /**
     * 一些全局变量
     */
//    static CloseableHttpClient httpClient = SSLUtils.createSSLClientDefault();
    /**
     * 发送get请求
     * @param url
     * @return httpresponse
     */
    public static JSONObject sentGet(String url, HashMap<String, String> header) throws IOException {
        HttpClient httpClient = new DefaultHttpClient();
        //创建请求实例
        HttpGet httpGet = new HttpGet(url);
//        System.out.println("sendGet:"+url);
        JSONObject content = null;
        //a.加入参
//        httpGet.setHeader("cookie", "PHPSESSID=5m8ltehht21qcb789u6808sgp7; Hm_lvt_ca368c21c1d2aa60e6f63d598c4cb02a=1649486265,1649603913; Hm_lpvt_ca368c21c1d2aa60e6f63d598c4cb02a=1649603918");
//        httpGet.setHeader("Accept", "application/json, text/javascript, */*; q=0.01");
//        httpGet.setHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");
        //b.用map里的key，value
        Iterator<Map.Entry<String, String>> it = header.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String,String> entry = it.next();
            httpGet.setHeader(entry.getKey(),entry.getValue());
        }

        CloseableHttpResponse closeableHttpResponse = null;
        try {
            //发送get请求
            closeableHttpResponse = (CloseableHttpResponse) httpClient.execute(httpGet);
            //entity类获取
            HttpEntity httpEntity = closeableHttpResponse.getEntity();
//            System.out.println("打印返回内容：====================================");
            String contenttype = String.valueOf(httpEntity.getContentType());
//            System.out.println("contenttype:"+contenttype);
            content = (JSONObject) JSONArray.parse(EntityUtils.toString(httpEntity));
            System.out.println("content:" + content);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭流
            closeableHttpResponse.close();
        }
        return content;
    }


    //测试方法
    public static void main(String[] args) throws IOException {
        JSONObject content = HttpRequest.sentGet("https://www.iamwawa.cn/home/lizhi/ajax",null);
//        Assert.assertEquals(content.get("data"),"我爱你");
    }
}
