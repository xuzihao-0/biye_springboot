package com.bjpowernode.mp06.controller;

import com.bjpowernode.mp06.entity.DefaultTask;
import com.bjpowernode.mp06.entity.TestUser;
import com.bjpowernode.mp06.entity.User;
import com.bjpowernode.mp06.mapper.DefaultTaskMapper;
import com.bjpowernode.mp06.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.ReactiveTransaction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * register下的请求不需要被拦截
 * 系统用户注册业务
 */

@RestController
@Slf4j
@RequestMapping("register")
public class Register {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private IUserService userService;
    @Autowired
    private DefaultTaskMapper defaultTaskMapper;

    @PostMapping("hi")
    public String hi(@RequestBody TestUser test){
        System.out.println(test.getName());
        System.out.println(test.getAge());
        return "你好"+test.getName()+"我已经给你返回信息了哦";
    }


    @GetMapping("default")
    public List<DefaultTask>  ttttttt(){
        String name="xuzihao";
        log.info("ss{}",name);

        List<Integer> integers = defaultTaskMapper.selectAllId();
        List<DefaultTask> defaultTasks = defaultTaskMapper.selectList(null);
        return defaultTasks;
    }

    @GetMapping("redis_test")
    public String redsi(){
        //redie测试方法
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new StringRedisSerializer());
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//        redisTemplate.opsForValue().set(1, 1);

//        System.out.println(redisTemplate.opsForValue().get(1)+" ");
        stringRedisTemplate.opsForValue().set("name1", "徐梓皓");
        String name1 = stringRedisTemplate.opsForValue().get("name1");


        return name1;
    }
    @PostMapping("user")
    public int register(@RequestBody User user){
        //注册用户
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setEnabled(true);
        user.setCredentialsNonExpired(true);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        System.out.println(user);
        int save = userService.register(user);
        return save;

    }



}
