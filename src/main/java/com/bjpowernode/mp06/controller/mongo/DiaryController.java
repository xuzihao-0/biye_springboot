package com.bjpowernode.mp06.controller.mongo;

import com.bjpowernode.mp06.entity.Diary;
import com.bjpowernode.mp06.entity.Mail;
import com.bjpowernode.mp06.service.MongoService;
import com.bjpowernode.mp06.service.impl.MongoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author xuzihao
 * @version 1.0
 * @date 2022/4/12 17:52
 */
@RestController
public class DiaryController {


    @Autowired
    private MongoServiceImpl mongoService;
    @Autowired
    private MongoTemplate mongoTemplate;
    @GetMapping("findOneDiary")
    public Diary findOne(Integer id){
        Diary one = mongoService.findOne(id);
        return one;

    }
//    分页查询用户日记
    @PostMapping("getAllByUser")
    public List<Diary> getAll(@RequestBody Map<String,String> map){
        int userId=0,size=10,page=1;
        if(map.containsKey("userId")){
            userId =Integer.parseInt(map.get("userId")) ;

        }
        if(map.containsKey("size")){
            size =Integer.parseInt(map.get("size")) ;

        }
        if(map.containsKey("size")){
            page =Integer.parseInt(map.get("page")) ;

        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("方法进入");
        System.out.println(userId);
        System.out.println(size);
        System.out.println(page);
        Query query = Query.query(Criteria.where("userId").is(userId));
        query.with(Sort.by(Sort.Order.asc("_id"))).skip(page*10).limit(size);
        List<Diary> dd = mongoTemplate.find(query, Diary.class);

        return dd;

    }


    @GetMapping("get_total_diary")
    public int getTotal(int userId){
        List<Diary> diaries = mongoService.findDiaries(userId);
         return diaries.size();
    }
    @PostMapping("insertDiary")
    public int insert(@RequestBody Diary diary){
        //设置时间 时区问题
        String timezone = "Asia/Shanghai";
        ZoneId of = ZoneId.of(timezone);
        LocalDate now = LocalDate.now(of);
        diary.setDate(now);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~``");
        System.out.println(now);



        Query query = new Query();
        query.fields().include("id");
        int max=0;
        List<Diary> dd = mongoTemplate.find(query, Diary.class);
        if(dd.isEmpty()){
            diary.setId(1);
        }else {
            for (Diary diarys : dd) {
                if(diarys.getId()>=max){
                    max=diarys.getId();
                }
            }
            //设置主键id
            diary.setId(max+1);
        }
        System.out.println(diary);
        int i = mongoService.insertDiary(diary);
        System.out.println(max);

        return i;




    }
    @GetMapping("findByUserId")
    public List<Diary> findAll(Integer userId){
        List<Diary> diaries = mongoService.findDiaries(userId);
        int size = diaries.size();

        System.out.println("111111111111111111111111111111111111111111111111111111");
        System.out.println(size);
        System.out.println("111111111111111111111111111111111111111111111111111111");
        return diaries;
    }

    @GetMapping("deleteDiary")
    public int delete(Integer id){
        //根据任务删除日记
        int delete = mongoService.delete(id);
        return delete;


    }
    @GetMapping("testMailMongo")
    public void ereowu(){
        Mail mail = new Mail();
        mail.setUid(6);
        mail.setMail("1186004721");
        Mail insert = mongoTemplate.save(mail);
        System.out.println(insert);

    }
    @GetMapping("findMailMongo")
    public void ereowudsadsa(){
        List<Mail> all = mongoTemplate.findAll(Mail.class);
        System.out.println(all);

    }


}
