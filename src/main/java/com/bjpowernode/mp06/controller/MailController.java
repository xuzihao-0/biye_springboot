package com.bjpowernode.mp06.controller;

import com.bjpowernode.mp06.entity.Jdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;

@RestController
public class MailController {
    //邮件服务controller 后期抽离成service层
    @Autowired
    private JavaMailSender javaMailSender;

    @GetMapping("hello")
    @Secured("ROLE_user")
    public String ss(Integer id, String name) {
        System.out.println("已经完场");
        return "" + id + name;
    }

    @GetMapping("test")
    @Secured("ROLE_admin")
    public String ss8(Integer id, String name) {
        System.out.println("已经完场");
        return "" + id + name;
    }

    @GetMapping("testq")
    public Jdata ss889(Integer id, String name) {
        Jdata jdata = new Jdata();
        jdata.setI(id);
        jdata.setDate(new Date());
        return jdata;
    }

    @GetMapping("login")
    public String sst() {

        return "未经过授权，请登录";
    }

    @GetMapping("mail")
    public String sendfMail(String text,String mail) {
        //纯文本邮件
        SimpleMailMessage message = new SimpleMailMessage();
        // 设置邮件主题
        message.setSubject("这是一封测试邮件");
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

        // 设置邮件的正文
        message.setText(text);
        // 发送邮件
        javaMailSender.send(message);
        return "done!!!!!!!!!!";
    }

    @GetMapping("mail_mul")
    public String mail_mul() throws MessagingException {
        //可以发送附件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        // true表示构建一个可以带附件的邮件对象
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject("这是一封测试邮件");
        helper.setFrom("1186004722@qq.com");
        helper.setTo("1186004722@qq.com");
        //helper.setCc("37xxxxx37@qq.com");
        //helper.setBcc("14xxxxx098@qq.com");
        helper.setSentDate(new Date());
        helper.setText("这是测试邮件的正文");
        // 第一个参数是自定义的名称，后缀需要加上，第二个参数是文件的位置
        helper.addAttachment("个人照片.jpg", new File("C:/Users/MI/" +
                "Desktop/个人/个人证件照/个人照片.jpg"));
        javaMailSender.send(mimeMessage);
        return "dome!!!!!";
    }


}
