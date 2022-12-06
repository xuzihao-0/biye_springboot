package com.bjpowernode.mp06.controller;

import com.bjpowernode.mp06.entity.Mail;
import com.bjpowernode.mp06.entity.OngoingTask;
import com.bjpowernode.mp06.service.MailService;
import com.bjpowernode.mp06.service.UserMailService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author xuzihao
 * @version 1.0
 * @date 2022/3/4 17:48
 */
@RestController
@Slf4j
public class TestController {
    @Autowired
    private MailService mailService;
    @Autowired
    private UserMailService userMailService;


    @GetMapping("testtt")
    public String testtt(Integer id,Integer uid){
        log.warn("你好我叫徐梓皓{}",id);
        System.out.println(id+"   hhhdshdks   "+uid);
        return "hello~~~~~~"+id+uid;
    }

    @PostMapping("test_o")
    public void test(@RequestBody OngoingTask ongoingTask){
        long c =ongoingTask.getEndDay().toEpochDay()-ongoingTask.getBeginDay().toEpochDay();
        ongoingTask.setTaskDay((int) c);
        ongoingTask.setTag(1);


        System.out.println(ongoingTask.getEndDay().toEpochDay()-ongoingTask.getBeginDay().toEpochDay());

        System.out.println(ongoingTask);
    }

    @PostMapping("testjson")
    public int tt(@RequestBody Map<String,String> map){
        if(map.containsKey("id")){
            System.out.println(map.get("id"));
        }
        System.out.println("~~~~~~~~~~~~");

        return Integer.parseInt(map.get("id"));
    }

    @GetMapping("testMail")
    public int testMail(String uid,String mail){
        log.info("方法进入~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        log.info("niha{}~~~~~~~~~~~~~~~~~~~~~", uid);
        System.out.println(uid);
        System.out.println(mail);
        int i = mailService.SendMail(mail,uid);
        return i;

    }
    @GetMapping("insertMail")
    public Mail fdjsklfjljalf(int uid,String mail){
        Mail save = userMailService.save(uid, mail);
        return save;
    }
}
