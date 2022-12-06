package com.bjpowernode.mp06.service.impl;

import com.bjpowernode.mp06.entity.User;
import com.bjpowernode.mp06.mapper.UserMapper;
import com.bjpowernode.mp06.service.IUserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int register(User user) {
        //注册用户
        int insert = userMapper.insert(user);
        return insert;
    }

    @Override
    public int changeUser(String name, String password, String telephone, Integer uid) {

        int i =userMapper.change(name,password,telephone,uid);
        return i;





    }

    @Override
    public List<Integer> findAll() {
        List<Integer> all = userMapper.findAll();
        return all;
    }
}
