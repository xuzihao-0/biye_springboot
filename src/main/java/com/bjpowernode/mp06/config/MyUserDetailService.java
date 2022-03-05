package com.bjpowernode.mp06.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bjpowernode.mp06.entity.Role;
import com.bjpowernode.mp06.entity.User;
import com.bjpowernode.mp06.entity.UserRole;
import com.bjpowernode.mp06.mapper.RoleMapper;
import com.bjpowernode.mp06.mapper.UserMapper;
import com.bjpowernode.mp06.mapper.UserRoleMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MyUserDetailService implements UserDetailsService {
    //实现userdetailService接口 返回用户信息以及权限
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //在用户表中找到用户
        QueryWrapper<User> qw = new QueryWrapper<>();
        HashMap<String, Object> mm = new HashMap<>();
        mm.put("username", username);
        qw.allEq(mm);
        User user = userMapper.selectOne(qw);
        //在role_user表中找到对应的rid
        Map<String, Object> map = new HashMap<>();
        map.put("uid", user.getId());
        List<UserRole> userRoles = userRoleMapper.selectByMap(map);

        Map<String, Object> mm2 = new HashMap<>();
        Iterator<UserRole> iterator = userRoles.iterator();
        List<Role> rr = new ArrayList<>();
        while (iterator.hasNext()) {
            UserRole next = iterator.next();
            mm2.put("id", next.getRid());
            List<Role> roles = roleMapper.selectByMap(mm2);
            rr.addAll(roles);
        }
        user.setRoles(rr);
//返回用户信息
        return user;
    }
}
