package com.bjpowernode.mp06.service;

import com.bjpowernode.mp06.entity.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xuzihao
 * @version 1.0
 * @date 2022/5/23 12:18
 */
@Service
public class UserMailService {
    @Autowired
    private MongoTemplate mongoTemplate;

    public Mail save(int uid,String mail){
        Mail mail1 = new Mail();
        mail1.setUid(uid);
        mail1.setMail(mail);
        Mail save = mongoTemplate.save(mail1);
        return save;
    }
    public List<Mail> findAll(){
        List<Mail> all = mongoTemplate.findAll(Mail.class);
        return all;
    }
    public Mail getMail(int id){


        Mail byId = mongoTemplate.findById(id, Mail.class);
        return byId;

    }

}
