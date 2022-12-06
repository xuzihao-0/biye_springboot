package com.bjpowernode.mp06.service;

import com.bjpowernode.mp06.entity.OngoingTask;
import com.bjpowernode.mp06.mapper.OngoingTaskMapper;
import com.bjpowernode.mp06.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author xuzihao
 * @version 1.0
 * @date 2022/5/20 15:25
 */
@Service
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private OngoingTaskMapper ongoingTaskMapper;
    public int SendMail(String mail,String id){
        int count = 0,number=0;
        //已完成任务列表
        List<OngoingTask> achievement = ongoingTaskMapper.getAchievement(id);
        for (OngoingTask ongoingTask : achievement) {
            //完成任务奖赏点总和
            count += ongoingTask.getTaskValue();
            number++;
        }
        String detail = achievement.toString();
        //纯文本邮件
        SimpleMailMessage message = new SimpleMailMessage();
        // 设置邮件主题
        message.setSubject("这是一封发送用户完成任务总奖赏点的邮件");
        // 设置邮件发送者，这个跟application.yml中设置的要一致
        message.setFrom("1186004722@qq.com");
        // 设置邮件接收者，可以有多个接收者，中间用逗号隔开，以下类似
        // message.setTo("10*****16@qq.com","12****32*qq.com");
        message.setTo(mail);
        // 设置邮件抄送人，可以有多个抄送人
//        message.setCc("2103325578qq.com");
        // 设置隐秘抄送人，可以有多个

        // 设置邮件发送日期
        message.setSentDate(new Date());
        String t1 = "亲爱的用户";
        String t2 = "你好";
        String t3 = "你在本系统中一共完成了";
        // 设置邮件的正文
        message.setText(t1+t2+": "+t3+number+"件任务，"+"任务奖赏点总和是"+count+"以下是完成任务列表： "+detail+"。坚持就是胜利，" +
                "希望你一直可以坚持完成加油");
        // 发送邮件
        javaMailSender.send(message);

        return 0;
    }
    public int sendMail1(String mail,String text){


        //纯文本邮件
        SimpleMailMessage message = new SimpleMailMessage();
        // 设置邮件主题
        message.setSubject("这是一封提醒用户打卡的邮件");
        // 设置邮件发送者，这个跟application.yml中设置的要一致
        message.setFrom("1186004722@qq.com");
        // 设置邮件接收者，可以有多个接收者，中间用逗号隔开，以下类似
        // message.setTo("10*****16@qq.com","12****32*qq.com");
        message.setTo(mail);
        // 设置邮件抄送人，可以有多个抄送人
//        message.setCc("2103325578qq.com");
        // 设置隐秘抄送人，可以有多个

        // 设置邮件发送日期
        message.setSentDate(new Date());
        String t1 = "亲爱的用户";
        String t2 = "你好";
        String t3 = "你在本系统中一共完成了";
        // 设置邮件的正文
        message.setText(text);
        // 发送邮件
        javaMailSender.send(message);

        return 0;


    }

}
