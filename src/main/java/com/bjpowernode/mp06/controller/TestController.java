package com.bjpowernode.mp06.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuzihao
 * @version 1.0
 * @date 2022/3/4 17:48
 */
@RestController
@Slf4j
public class TestController {


    @GetMapping("testtt")
    public String testtt(Integer id,Integer uid){
        log.warn("你好我叫徐梓皓{}",id);
        System.out.println(id+"   hhhdshdks   "+uid);
        return "hello~~~~~~"+id+uid;
    }
}
