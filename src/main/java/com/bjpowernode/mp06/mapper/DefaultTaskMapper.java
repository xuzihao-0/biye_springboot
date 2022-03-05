package com.bjpowernode.mp06.mapper;

import com.bjpowernode.mp06.cache.RedisCache;
import com.bjpowernode.mp06.entity.DefaultTask;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.CacheNamespace;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xuzihao
 * @since 2022-02-16
 * 缓存测试mapper
 */
@CacheNamespace(implementation = RedisCache.class)
public interface DefaultTaskMapper extends BaseMapper<DefaultTask> {

    List<Integer> selectAllId();
}
