package com.bjpowernode.mp06.controller.schedule;

import com.bjpowernode.mp06.entity.Mail;
import com.bjpowernode.mp06.entity.OngoingTask;
import com.bjpowernode.mp06.service.IOngoingTaskService;
import com.bjpowernode.mp06.service.MailService;
import com.bjpowernode.mp06.service.UserMailService;
import com.bjpowernode.mp06.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScheduleController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private MailService mailService;
    @Autowired
    private UserMailService userMailServicel;
    @Autowired
    private IOngoingTaskService ongoingTaskService;

//    @Scheduled(fixedRate = 100000)
//    public void schMethod() {
//        //定时任务
//        //遍历用户
//        List<Integer> all = userService.findAll();
//
//        for (Integer integer : all) {
////            获取用户邮箱
//            Mail mail = userMailServicel.getMail(integer);
////            获取未完成任务
//            List<OngoingTask> goTask = ongoingTaskService.getGoTask(integer);
//            String s = goTask.toString();
////            发送邮件
//            mailService.sendMail1(mail.getMail(), s);
//
//
//        }
//
//        System.out.println("this is a test");
//    }
}
