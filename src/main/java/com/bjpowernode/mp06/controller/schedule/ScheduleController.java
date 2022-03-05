package com.bjpowernode.mp06.controller.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleController {


    @Scheduled(fixedRate = 50000)
    public void schMethod() {
        //定时任务
        System.out.println("this is a test");
    }
}
