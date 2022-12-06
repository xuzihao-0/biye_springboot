package com.bjpowernode.mp06.service;

import com.bjpowernode.mp06.entity.OngoingTask;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xuzihao
 * @since 2022-02-16
 */
public interface IOngoingTaskService extends IService<OngoingTask> {

    List<OngoingTask> selectByUid(Integer id);

    OngoingTask deleteTask(Integer uid, String task_name);

    int insertTask(OngoingTask ongoingTask);

    int updateTask(OngoingTask ongoingTask);

    List<OngoingTask> getGoingTask(HashMap<String, Object> map);
    List<OngoingTask> getGoTask(int uid);


    int getTotal(Integer uid,Integer tag);
}
