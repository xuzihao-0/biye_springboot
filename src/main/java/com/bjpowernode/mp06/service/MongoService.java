package com.bjpowernode.mp06.service;

import com.bjpowernode.mp06.entity.Diary;

import java.security.PrivateKey;
import java.util.List;

public interface MongoService {
    //用户日记相关接口
    List<Diary> findDiaries(int userId);
    int delete(int id);
    Diary findOne(int id);
    int insertDiary(Diary diary);
    int findId();




}
