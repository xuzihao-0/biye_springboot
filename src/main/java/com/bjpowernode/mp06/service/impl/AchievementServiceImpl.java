package com.bjpowernode.mp06.service.impl;

import com.bjpowernode.mp06.entity.Achievement;
import com.bjpowernode.mp06.mapper.AchievementMapper;
import com.bjpowernode.mp06.service.IAchievementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xuzihao
 * @since 2022-02-16
 */
@Service
public class AchievementServiceImpl extends ServiceImpl<AchievementMapper, Achievement> implements IAchievementService {

    @Autowired
    private AchievementMapper achievementMapper;

    @Override
    public List<Achievement> selectAll() {
        //查询出achieve表中所有数据
        List<Achievement> achievements = achievementMapper.selectList(null);
        return achievements;
    }
}
