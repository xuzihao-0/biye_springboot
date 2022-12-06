package com.bjpowernode.mp06.controller;

import com.bjpowernode.mp06.service.SmsService;
import com.bjpowernode.mp06.util.HttpUtils;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuzihao
 * @version 1.0
 * @date 2022/3/4 22:52
 */
@RestController
public class Sms {
    @Autowired
    private SmsService smsService;
    @GetMapping("register/testhh")
    public int test(){
        String host = "https://jumsendsms.market.alicloudapi.com";
        String path = "/sms/send-upgrade";
        String method = "POST";
        String appcode = "6cfcb960c5ab4602bc3e267f6e266705";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("mobile", "18758860965");
        querys.put("templateId", "M72CB42894");
        querys.put("value", "114567");
        Map<String, String> bodys = new HashMap<String, String>();


        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }



        return 0;
    }
    @PostMapping("testSms")
    public String send(String telephone,String message){
        int i = smsService.SendMessage(telephone, message);
        if(i==1)
            return "信息已经发送成功";
        return "信息发送失败，请检查";
    }

}
