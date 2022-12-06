package com.bjpowernode.mp06.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bjpowernode.mp06.entity.DeletedTask;
import com.bjpowernode.mp06.entity.OngoingTask;
import com.bjpowernode.mp06.mapper.DeletedTaskMapper;
import com.bjpowernode.mp06.mapper.OngoingTaskMapper;
import com.bjpowernode.mp06.service.IOngoingTaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mysql.cj.interceptors.QueryInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xuzihao
 * @since 2022-02-16
 */
@Service
public class OngoingTaskServiceImpl extends ServiceImpl<OngoingTaskMapper, OngoingTask> implements IOngoingTaskService {

    @Autowired
    private OngoingTaskMapper ongoingTaskMapper;
    @Autowired
    private DeletedTaskMapper deletedTaskMapper;


    @Override
    public List<OngoingTask> selectByUid(Integer id) {
        //根据id 查询用户的所有任务包括已经完成 未完成的任务
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", id);
        List<OngoingTask> ongoingTasks = ongoingTaskMapper.selectByMap(map);
        return ongoingTasks;
    }
    public List<OngoingTask> selectByUidUnSucess(Integer id) {
        //根据id 查询用户的所有任务包括已经完成 未完成的任务
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", id);
        map.put("tag", 1);
        List<OngoingTask> ongoingTasks = ongoingTaskMapper.selectByMap(map);
        return ongoingTasks;
    }

    @Override
    @Transactional
    public OngoingTask deleteTask(Integer uid, String task_name) {
        //删除任务
        int insert = 0;
        DeletedTask deletedTask = new DeletedTask();
        QueryWrapper<OngoingTask> qu = new QueryWrapper<>();
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", uid);
        map.put("task_name", task_name);
        qu.allEq(map);
        OngoingTask ongoingTask = ongoingTaskMapper.selectOne(qu);
        int i = ongoingTaskMapper.deleteById(ongoingTask.getId());
        if (i != 0) {//如果在ongoingtask表中删除成功，则插入deleted表中，否则返回null
            deletedTask.setUid(ongoingTask.getUid());
            deletedTask.setTaskName(ongoingTask.getTaskName());
            deletedTask.setTaskDay(ongoingTask.getTaskDay());
            deletedTask.setEndDay(ongoingTask.getEndDay());
            deletedTask.setTaskValue(ongoingTask.getTaskValue());
            deletedTask.setBeginDay(ongoingTask.getBeginDay());
            deletedTask.setTypeId(ongoingTask.getTypeId());
            deletedTask.setTaskDescription(ongoingTask.getTaskDescription());
            deletedTask.setTag(ongoingTask.getTag());
            insert = deletedTaskMapper.insert(deletedTask);

        }
        //  int i = ongoingTaskMapper.deleteById(ongoingTask.getId());
        if (i == 1 && insert == 1) {
            System.out.println("删除成功");
            return ongoingTask;
        }
        return null;
    }

    @Override
    @Transactional
    public int insertTask(OngoingTask ongoingTask) {
        //插入任务
        int insert = ongoingTaskMapper.insert(ongoingTask);
        return insert;
    }

    @Override
    public int updateTask(OngoingTask ongoingTask) {
        //更新任务
        QueryWrapper<OngoingTask> qu = new QueryWrapper<>();
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", ongoingTask.getUid());
        map.put("task_name", ongoingTask.getTaskName());
        qu.allEq(map);

        OngoingTask ongoingTask1 = ongoingTaskMapper.selectOne(qu);
        ongoingTask.setId(ongoingTask1.getId());
        int i = ongoingTaskMapper.updateById(ongoingTask);
        return i;
    }

    @Override
    public int getTotal(Integer uid,Integer tag) {
        QueryWrapper<OngoingTask> qw  = new QueryWrapper<>();
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", uid);
        map.put("tag", tag);
        qw.allEq(map);
        int  count =ongoingTaskMapper.selectCount(qw).intValue();
        return count;
    }

    @Override
    public List<OngoingTask> getGoingTask(HashMap<String, Object> map) {
        List<OngoingTask> ongoingTasks = ongoingTaskMapper.selectByMap(map);
        return ongoingTasks;
    }

    @Override
    public List<OngoingTask> getGoTask(int uid) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", uid);
        map.put("tag", 1);
        List<OngoingTask> task = getGoingTask(map);
        return task;
    }


}
