package com.bjpowernode.mp06.mapper;

import com.bjpowernode.mp06.entity.User;
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
public interface UserMapper extends BaseMapper<User> {

    int change(@Param("username") String name,@Param("password") String password, @Param("telephone") String telephone, @Param("id") Integer uid);
    List<Integer> findAll();
}
