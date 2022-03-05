package com.bjpowernode.mp06.service;

import com.bjpowernode.mp06.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xuzihao
 * @since 2022-02-16
 */
public interface IUserService extends IService<User> {

    int register(User user);

    int changeUser(String name, String password, String telephone, Integer uid);
}
