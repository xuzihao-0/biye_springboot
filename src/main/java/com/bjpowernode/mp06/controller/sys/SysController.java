package com.bjpowernode.mp06.controller.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bjpowernode.mp06.entity.TestUser;
import com.bjpowernode.mp06.entity.User;
import com.bjpowernode.mp06.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class SysController {
    @Autowired
    private IUserService userService;



    @PostMapping("update_user")
    public boolean update(@RequestBody User user) {
        //更新用户
        System.out.println(user);
        QueryWrapper<User> qw = new QueryWrapper<>();
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", user.getId());
        qw.allEq(map);
        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setCredentialsNonExpired(true);
        user.setAccountNonLocked(true);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        System.out.println(bCryptPasswordEncoder.encode(user.getPassword()));

        boolean update = userService.update(user, qw);
        return update;

    }
}
