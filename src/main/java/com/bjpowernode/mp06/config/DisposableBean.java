package com.bjpowernode.mp06.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class DisposableBean implements org.springframework.beans.factory.DisposableBean {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void destroy() throws Exception {
        //spring boot 应用关闭后需要清理在线人数 置为0 存储在redis中
        redisTemplate.opsForValue().set("online_count", "0");

    }
}
