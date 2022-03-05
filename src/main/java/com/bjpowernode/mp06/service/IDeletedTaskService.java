package com.bjpowernode.mp06.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bjpowernode.mp06.entity.DeletedTask;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xuzihao
 * @since 2022-02-16
 */
public interface IDeletedTaskService extends IService<DeletedTask> {

    List<DeletedTask> seleteAll(Integer uid);

    int getTotal(QueryWrapper<DeletedTask> qw);
}
