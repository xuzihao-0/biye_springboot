package com.bjpowernode.mp06.mapper;

import com.bjpowernode.mp06.entity.OngoingTask;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xuzihao
 * @since 2022-02-16
 */
public interface OngoingTaskMapper extends BaseMapper<OngoingTask> {
    List<OngoingTask> getAchievement(@Param("uid") String uid);

}
