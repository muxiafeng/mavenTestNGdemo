package com.chenhongzhi.maven;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.api.scripting.ScriptUtils;
import jdk.nashorn.internal.runtime.JSONFunctions;
import jdk.nashorn.internal.runtime.JSONListAdapter;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;

import java.io.IOException;

public class HttpRequest {
    /**
     * 一些全局变量
     */
    static HttpClient httpClient = new DefaultHttpClient();

    /**
     * 发送get请求
     * @param url
     * @return httpresponse
     */
    public static JSONObject sentGet(String url) throws IOException {
        //创建请求实例
        HttpGet httpGet = new HttpGet(url);
//        System.out.println("sendGet:"+url);
        JSONObject content = null;
        //加入参
        httpGet.setHeader("cookie", "PHPSESSID=it13e8gm7mecrfiq9lm8nrm0q5; Hm_lvt_ca368c21c1d2aa60e6f63d598c4cb02a=1649486265; Hm_lpvt_ca368c21c1d2aa60e6f63d598c4cb02a=1649488617");
        httpGet.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        httpGet.setHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.75 Safari/537.36");
        //发送get请求
        CloseableHttpResponse closeableHttpResponse = (CloseableHttpResponse) httpClient.execute(httpGet);
        try {
            //entity类获取
            HttpEntity httpEntity = closeableHttpResponse.getEntity();
//            System.out.println("打印返回内容：====================================");
            String contenttype = String.valueOf(httpEntity.getContentType());
//            System.out.println("contenttype:"+contenttype);
            content = (JSONObject) JSONArray.parse(EntityUtils.toString(httpEntity));
//            System.out.println("content:"+content);
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            //关闭流
            closeableHttpResponse.close();
        }
        return content;
    }


    //测试方法
//    public static void main(String[] args) throws IOException {
//        JSONObject content = HttpRequest.sentGet("https://www.iamwawa.cn/home/lizhi/ajax");
//        Assert.assertEquals(content.get("data"),"我爱你");
//    }
}
