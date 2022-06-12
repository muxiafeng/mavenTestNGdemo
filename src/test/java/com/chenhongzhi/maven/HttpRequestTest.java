package com.chenhongzhi.maven;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class HttpRequestTest {

    @BeforeMethod
    public String setUp() {
//        System.out.println("@BeforeMethod");
       //使用before传参,声明该方法的返回值类型并返回相应数据
        return "string123";
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("@AfterMethod");
    }

    //1.使用testNG.xml传参，并右键xml文件run
//    @Test(timeOut = 800,enabled = true)
//    @Parameters({"url"})
//    public void testSentGet(String url) {
//        System.out.println("@Test"+url);
//        try {
//            JSONObject json = HttpRequest.sentGet(url);
//            String expectInfo = "查询成功！";
//            System.out.println("expectInfo:"+expectInfo);
//            String actualInfo = (String) json.get("info");
//            System.out.println("actualInfo:"+actualInfo);
//            Assert.assertEquals(expectInfo,actualInfo);
//        }catch (Exception e){
//            e.printStackTrace();
//            Reporter.log(e.getMessage());
//        }
//    }


    //2.使用before传递参数，setUp方法返回数据并在test中引用
//    @Test(expectedExceptions = Exception.class)
//    public void testSentGet() throws Exception {
//        System.out.println("@Test");
//        JSONObject json = HttpRequest.sentGet(setUp()[1]);
//        String expectInfo = "查询成功！";
//        System.out.println("expectInfo:"+expectInfo);
//        String actualInfo = (String) json.get("info");
//        System.out.println("actualInfo:"+actualInfo);
//        Assert.assertEquals(expectInfo,actualInfo);
//        throw new Exception();
//    }
    //3.使用before传递参数，setUp方法返回数据并在test中引用
    @Test
    public void testSentGet() throws Exception {
        JSONObject json = HttpRequest.sentGet("https://www.iamwawa.cn/home/lizhi/ajax");
        System.out.println(setUp());
        String expectInfo = "查询成功！";
        System.out.println("expectInfo:"+expectInfo);
        String actualInfo = (String) json.get("info");
        System.out.println("actualInfo:"+actualInfo);
        Assert.assertEquals(expectInfo,actualInfo);
    }
}