package com.bjpowernode.mp06.controller.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjpowernode.mp06.entity.DefaultTask;
import com.bjpowernode.mp06.mapper.DefaultTaskMapper;
import com.bjpowernode.mp06.service.impl.DefaultTaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.util.List;

@RestController

public class DefaultTaskController {


    @Autowired
    private DefaultTaskServiceImpl defaultTaskService;

    @GetMapping("page_find")
    public List<DefaultTask> pageSelect(Integer pageSize, Integer index, @RequestParam(required = false, defaultValue = "id") String column) {
        QueryWrapper<DefaultTask> qw = new QueryWrapper<>();
        qw.orderBy(true, false, column);
        IPage<DefaultTask> page = new Page<>();
        page.setSize((long) pageSize);
        page.setCurrent((long) index);
        IPage<DefaultTask> page1 = defaultTaskService.page(page, qw);
        List<DefaultTask> records = defaultTaskService.page(page, qw).getRecords();
        System.out.println("```````````````````````````");
        System.out.println("```````````````````````````");
        System.out.println("```````````````````````````");
        System.out.println("总数是：" + page1.getTotal());
        System.out.println("每页显示条数" + page1.getSize());
        System.out.println("当前分页总页数" + page1.getPages());
        System.out.println("当前页" + page1.getCurrent());
        System.out.println("```````````````````````````");
        System.out.println("```````````````````````````");
        System.out.println("```````````````````````````");

        return records;
    }

    @GetMapping("default_all")
    public List<DefaultTask> ss() {
        //查询所有系统默认任务并返回
        List<DefaultTask> all = defaultTaskService.findAll();
        return all;

    }

    @GetMapping("default_one")
    public DefaultTask sst() {
        //随机查询并返回default_task表中的一条数据，
        DefaultTask defaultTask = defaultTaskService.randomOne();
        return defaultTask;

    }

}
