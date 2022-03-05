package com.bjpowernode.mp06.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bjpowernode.mp06.entity.DeletedTask;
import com.bjpowernode.mp06.mapper.DeletedTaskMapper;
import com.bjpowernode.mp06.service.IDeletedTaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xuzihao
 * @since 2022-02-16
 */
@Service
public class DeletedTaskServiceImpl extends ServiceImpl<DeletedTaskMapper, DeletedTask> implements IDeletedTaskService {
    @Autowired
    private DeletedTaskMapper deletedTaskMapper;

    @Override
    public int getTotal(QueryWrapper<DeletedTask> qw) {
        int i = deletedTaskMapper.selectCount(qw).intValue();
        return  i;
    }

    @Override
    public List<DeletedTask> seleteAll(Integer uid) {
        Map<String, Object> map = new HashMap<>();
        map.put("uid", uid);
        List<DeletedTask> deletedTasks = deletedTaskMapper.selectByMap(map);
        return deletedTasks;
    }
}
