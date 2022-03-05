package com.bjpowernode.mp06.cache;

import com.bjpowernode.mp06.util.ApplicationContextUtils;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;


public class RedisCache implements Cache {
    //redis 二级缓存
    private final String id;

    @Override
    public String getId() {
        return this.id;
    }

    public RedisCache(String id) {
        this.id = id;
    }

    @Override
    public void putObject(Object key, Object value) {
        System.out.println("key = " + key.toString());
        System.out.println("value = " + value);
        getRedisTemplate().opsForHash().put(id.toString(), getKeyToMD5(key.toString()), value);
    }

    @Override
    public Object getObject(Object key) {
        System.out.println("key = " + key.toString());
        return getRedisTemplate().opsForHash().get(id.toString(), getKeyToMD5(key.toString()));
    }

    @Override
    public Object removeObject(Object key) {
        System.out.println("保留方法");
        return null;
    }

    @Override
    public void clear() {
        //清楚namespace hash类型中存放的数据
        System.out.println("清空缓存");
        getRedisTemplate().delete(id.toString());

    }

    @Override
    public int getSize() {
        return getRedisTemplate().opsForHash().size(id.toString()).intValue();
    }

    //封装redisTemplate
    private RedisTemplate getRedisTemplate() {
        //通过application工具类获取redisTemplate
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }

    //封装一个对key进行md5处理方法
    private String getKeyToMD5(String key) {
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }

}
