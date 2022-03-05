package com.bjpowernode.mp06.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bjpowernode.mp06.entity.DefaultTask;
import com.bjpowernode.mp06.mapper.DefaultTaskMapper;
import com.bjpowernode.mp06.service.IDefaultTaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.xml.internal.fastinfoset.util.FixedEntryStringIntMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xuzihao
 * @since 2022-02-16
 */
@Service
public class DefaultTaskServiceImpl extends ServiceImpl<DefaultTaskMapper, DefaultTask> implements IDefaultTaskService {
    @Autowired
    private DefaultTaskMapper defaultTaskMapper;

    @Override
    public List<DefaultTask> findAll() {
        //查询所有默认任务
        List<DefaultTask> defaultTasks = defaultTaskMapper.selectList(null);

        return defaultTasks;

    }

    @Override
    public DefaultTask randomOne() {
        //随机获得一个默认任务
        List<Integer> integers = defaultTaskMapper.selectAllId();
        int size = integers.size();
        long l = System.currentTimeMillis();
        int index = (int) l % size;
        DefaultTask defaultTask = defaultTaskMapper.selectById(integers.get(index));
        return defaultTask;
    }

}
