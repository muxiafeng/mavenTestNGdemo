package com.chenhongzhi.maven;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import org.testng.annotations.*;

import java.util.HashMap;

public class HttpRequestTest {

//    @BeforeMethod
//    public String setUp() {
////        System.out.println("@BeforeMethod");
//       //使用before传参,声明该方法的返回值类型并返回相应数据
//        return "string123";
//    }
    @BeforeMethod
    public HashMap setUp() {
        //使用before传参,声明该方法的返回值类型并返回相应数据
        HashMap map = new HashMap();
        map.put("Cookie","123123");
        map.put("AAA","456456");
        return map;
    }

    @AfterMethod
    public void tearDown() {
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
//    @Listeners()
    @Test(timeOut = 3500)
    public void testSentGet() throws Exception {
        JSONObject json = HttpRequest.sentGet("https://api.bilibili.com/x/space/acc/info?mid=29660881&jsonp=jsonp",setUp());
        //获取json指定节点值，用jsonPath解析
        System.out.println(json.get("data.name"));
        System.out.println(JSONPath.read(String.valueOf(json),"$.data.name"));
        assert JSONPath.read(String.valueOf(json),"$.data.name").equals("陈七十一");

    }
    @org.testng.annotations.Test(enabled = false)
    public void testSet(){

    }


}