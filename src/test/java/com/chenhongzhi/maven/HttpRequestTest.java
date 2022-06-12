package com.chenhongzhi.maven;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import org.testng.annotations.*;
import org.testng.internal.thread.ThreadTimeoutException;

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
    //3.使用dataProvider传参
//    @Listeners()
//    @Test(timeOut = 1500,expectedExceptions = ThreadTimeoutException.class)
    @Test(timeOut = 1500,dataProvider = "data")
//    @DataProvider(name = "data()")
    public void testSentGet(String url, HashMap<String, String> header) throws Exception {
//        System.out.println(url+header.);
        JSONObject json = HttpRequest.sentGet(url,header);
//        System.out.println(json.get("data.name"));
        //获取json指定节点值，用jsonPath解析
        System.out.println(JSONPath.read(String.valueOf(json),"$.data"));
//        assert JSONPath.read(String.valueOf(json),"$.data.name").equals("陈七十一");

    }
    @org.testng.annotations.Test(enabled = false)
    public void testSet(){

    }

    @DataProvider
    public Object[][] data(){
        HashMap<String, String> map = new HashMap<String, String>();
        Object[][] objects = new Object[][]{
                {"https://api.bilibili.com/x/member/web/account",new HashMap<String,String>().put("cookie","123")},
                {"https://api.bilibili.com/x/space/acc/info?mid=29660881&jsonp=jsonp",new HashMap<String,String>() {{put("cookie","123123");}}},
                {"https://api.bilibili.com/x/member/web/account",new HashMap<String,String>() {{put("cookie","buvid3=C3E3A046-603A-4634-94ED-2BE3D47A360A58518infoc; i-wanna-go-back=-1; _uuid=E494B747-82A6-2374-8374-492FD108F811C59149infoc; buvid4=15D3F410-C19F-103D-8F36-CAE94B40F4AE64250-022061217-+qGOwSDgeSO7i21VY5uiPA%3D%3D; CURRENT_BLACKGAP=0; blackside_state=0; rpdid=|(Rll)~|l~k0J'uYll|k)uJk; fingerprint=aa479d84fe8d633d2380ecaea755fae6; buvid_fp_plain=undefined; sid=6frtc6nc; bp_video_offset_29660881=670767393664925765; fingerprint3=bf9f7da6a4edf5858da035449cdb25df; PVID=1; LIVE_BUVID=AUTO1216550310822213; CURRENT_FNVAL=80; innersign=0; b_lsid=BDD28B35_1815853B1E5; b_timer=%7B%22ffp%22%3A%7B%22333.1007.fp.risk_C3E3A046%22%3A%221815853BFA1%22%2C%22333.42.fp.risk_C3E3A046%22%3A%221815853C46A%22%7D%7D; _jct=622b52e0ea5c11ecb42d7e572de979e9; DedeUserID=29660881; DedeUserID__ckMd5=bfce7cf54522052b; SESSDATA=3adff160%2C1670596315%2C77f09*61; bili_jct=fb692ea5d47cecb253fc57c7fc9efb49; b_ut=5; buvid_fp=aa479d84fe8d633d2380ecaea755fae6");}}},
        };
        return objects;
    }

}