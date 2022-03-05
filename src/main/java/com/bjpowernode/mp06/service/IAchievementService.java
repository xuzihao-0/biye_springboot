package com.bjpowernode.mp06.service;

import com.bjpowernode.mp06.entity.Achievement;
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
public interface IAchievementService extends IService<Achievement> {

    List<Achievement> selectAll();
}
