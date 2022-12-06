package com.bjpowernode.mp06.controller.user;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjpowernode.mp06.entity.Achievement;
import com.bjpowernode.mp06.entity.DeletedTask;
import com.bjpowernode.mp06.entity.OngoingTask;
import com.bjpowernode.mp06.entity.SysDayFinished;

import com.bjpowernode.mp06.service.IAchievementService;
import com.bjpowernode.mp06.service.IDeletedTaskService;
import com.bjpowernode.mp06.service.IOngoingTaskService;
import com.bjpowernode.mp06.service.ISysDayFinishedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TaskController {
    //任务controller 用户查询都在这里
    @Autowired
    private IDeletedTaskService deletedTaskService;

    @Autowired
    private ISysDayFinishedService sysDayFinishedService;
    @Autowired
    private IAchievementService achievementService;

    @Autowired
    private IOngoingTaskService iOngoingTaskService;

    @GetMapping("get_total")
    public int getTotal(Integer uid, Integer tag) {

        int count = iOngoingTaskService.getTotal(uid, tag);
        return count;
    }

    @GetMapping("get_total_delete")
    public int getDeleteCount(Integer uid) {
        QueryWrapper<DeletedTask> qw = new QueryWrapper<>();
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", uid);
        qw.allEq(map);
        int i = deletedTaskService.getTotal(qw);
        return i;
    }


    @GetMapping("find_task_going_page")
    public List<OngoingTask> findPage(Integer uid, Integer size, Integer current) {
        // 页数从1开始 分页查询
        //查询出用户所有未完成的任务,tag为标记为表明是否完成 tag=1 表示未完成，tag=2表示任务已经完成
        QueryWrapper<OngoingTask> queryWrapper = new QueryWrapper<>();
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", uid);
        map.put("tag", 1);
        queryWrapper.allEq(map);
        IPage<OngoingTask> page = new Page<>();
        page.setCurrent(current);
        page.setSize(size);
        IPage<OngoingTask> page1 = iOngoingTaskService.page(page, queryWrapper);
        long total = page1.getTotal();
        System.out.println("总行数是---------------" + total);
        List<OngoingTask> records = page1.getRecords();
        return records;
    }

    @GetMapping("find_task_finished_page")
    public List<OngoingTask> findFinishedPage(Integer uid, Integer size, Integer current) {
        // 页数从1开始 分页查询
        //查询出用户所有完成的任务,tag为标记为表明是否完成 tag=1 表示未完成，tag=2表示任务已经完成
        QueryWrapper<OngoingTask> queryWrapper = new QueryWrapper<>();
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", uid);
        map.put("tag", 2);
        queryWrapper.allEq(map);
        IPage<OngoingTask> page = new Page<>();
        page.setCurrent(current);
        page.setSize(size);
        IPage<OngoingTask> page1 = iOngoingTaskService.page(page, queryWrapper);
        long total = page1.getTotal();
        System.out.println("总行数是---------------" + total);
        List<OngoingTask> records = page1.getRecords();
        return records;
    }

    @GetMapping("find_delete_page")
    public List<DeletedTask> findPageDelete(Integer uid, Integer size, Integer current) {
        QueryWrapper<DeletedTask> qw = new QueryWrapper<>();
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", uid);
        qw.allEq(map);
        IPage<DeletedTask> page = new Page<>();
        page.setCurrent(current);
        page.setSize(size);
        IPage<DeletedTask> page1 = deletedTaskService.page(page, qw);
        List<DeletedTask> records = page1.getRecords();
        return records;
    }


    @PostMapping("add_task")
    public int insertTask(@RequestBody OngoingTask ongoingTask) {
        //用户添加任务
//        LocalDate now = LocalDate.now();
//        LocalDate date = now.plusDays(21);
//        System.out.println(now+"   "+date);

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(ongoingTask.getBeginDay());
        System.out.println(ongoingTask);
        long c =ongoingTask.getEndDay().toEpochDay()-ongoingTask.getBeginDay().toEpochDay();
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(ongoingTask.getBeginDay());
        System.out.println(ongoingTask.getEndDay());
        System.out.println(c);
        ongoingTask.setTaskDay((int) c);
        ongoingTask.setTag(1);
        int i = iOngoingTaskService.insertTask(ongoingTask);
        return i;
    }

    @GetMapping("find_task_going")
    public List<OngoingTask> tt(Integer uid) {
        //查询出用户所有未完成的任务,tag为标记为表明是否完成 tag=1 表示未完成，tag=2表示任务已经完成
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", uid);
        map.put("tag", 1);
        List<OngoingTask> task = iOngoingTaskService.getGoingTask(map);

        return task;
    }

    @GetMapping("find_task_finished")
    public List<OngoingTask> findFinished(Integer uid) {
        //根据用户id 查询出所有标记为2 即已经完成的任务
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", uid);
        map.put("tag", 2);
        List<OngoingTask> task = iOngoingTaskService.getGoingTask(map);
        return task;
    }

    @GetMapping("find_task_delete")
    public List<DeletedTask> findDelete(Integer uid) {
        List<DeletedTask> tasks = deletedTaskService.seleteAll(uid);
        return tasks;


    }

    @PostMapping("delete_task")
    public OngoingTask delete(Integer uid, String task_name) {
        //用户删除任务，返回null表明不成功，返回删除数据表示成功
        OngoingTask ongoingTask = iOngoingTaskService.deleteTask(uid, task_name);
        return ongoingTask;
    }

    @Transactional
    @PostMapping("update_task")
    public boolean update(@RequestBody OngoingTask ongoingTask) {
        if (ongoingTask.getTag() == 2) {

            //即已经完成,需要在sys_day_finished中记录一下
            LocalDate now = LocalDate.now();
            System.out.println("``````````````````````````");
            System.out.println("``````````````````````````");
            System.out.println("``````````````````````````");
            System.out.println(now);
            System.out.println("````````````````````````````");
            System.out.println("````````````````````````````");
            System.out.println("````````````````````````````");
            QueryWrapper<SysDayFinished> qu = new QueryWrapper<>();
            HashMap<String, Object> map = new HashMap<>();
            map.put("time_day", now);
            qu.allEq(map);
            SysDayFinished one = sysDayFinishedService.getOne(qu);
            if (one != null) {
                one.setCount(one.getCount() + 1);
                boolean b = sysDayFinishedService.saveOrUpdate(one, qu);
                System.out.println(b);

            } else {

                SysDayFinished sysDayFinished = new SysDayFinished();
                sysDayFinished.setTimeDay(now);
                sysDayFinished.setCount(1);
                boolean save = sysDayFinishedService.save(sysDayFinished);
                System.out.println(save);
            }
            //同时也需要在achieve表中记录一下获得总成就
            QueryWrapper<Achievement> queryWrapper = new QueryWrapper<>();
            HashMap<String, Object> achieveMap = new HashMap<>();
            achieveMap.put("uid", ongoingTask.getUid());
            queryWrapper.allEq(achieveMap);
            Achievement ach = achievementService.getOne(queryWrapper);

            if (ach != null) {
                ach.setCount(ach.getCount() + ongoingTask.getTaskValue());
                achievementService.update(ach, queryWrapper);
            } else {
                Achievement achievement = new Achievement();
                achievement.setUid(ongoingTask.getUid());
                achievement.setCount(ongoingTask.getTaskValue());
                achievementService.save(achievement);
            }


        }
        boolean b = iOngoingTaskService.updateById(ongoingTask);
        return b;
    }
    @GetMapping("hhhhhhhhhhhhhhhh")
    public List<OngoingTask> fdsfdsf(Integer uid){
        List<OngoingTask> goTask = iOngoingTaskService.getGoTask(uid);
        return goTask;

    }


}
