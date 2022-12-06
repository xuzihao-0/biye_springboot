package com.bjpowernode.mp06.service.impl;

import com.bjpowernode.mp06.entity.Diary;
import com.bjpowernode.mp06.service.MongoService;
import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xuzihao
 * @version 1.0
 * @date 2022/4/12 17:44
 */
@Service
public class MongoServiceImpl implements MongoService {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public List<Diary> findDiaries(int userId) {
//        根据用户id查找所有
        List<Diary> userId1 = mongoTemplate.find(Query.query(Criteria.where("userId").is(userId)), Diary.class);
        return userId1;
    }

    @Override
    public int delete(int id) {
//        根据文档id删除
        DeleteResult id1 = mongoTemplate.remove(Query.query(Criteria.where("id").is(id)), Diary.class);
        if(id1==null)
            return 0;

        return 1;
    }

    @Override
    public Diary findOne(int id) {
//        根据文档id查找
        Diary byId = mongoTemplate.findById(id, Diary.class);
        return byId;
    }

    @Override
    public int insertDiary(Diary diary) {
//        插入数据

        Diary insert = mongoTemplate.insert(diary);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(insert);
        if(insert!=null)
            return 1;
        return 0;
    }

    @Override
    public int findId() {
        Query query = new Query();
        query.fields().include("id");
        ArrayList<Integer> ints = new ArrayList<Integer>();
        List<Diary> dd = mongoTemplate.find(query, Diary.class);
        for (Diary diary : dd) {
            ints.add(diary.getId());
        }
        Integer[] objects = (Integer[]) ints.toArray();
        Arrays.sort(objects);
        System.out.println(objects);




        return  0;
    }
}
