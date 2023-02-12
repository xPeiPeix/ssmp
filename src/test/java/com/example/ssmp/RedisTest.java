package com.example.ssmp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class RedisTest {
    @Autowired
//    private RedisTemplate redisTemplate;
    private StringRedisTemplate redisTemplate;

    @Test
    void set(){
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set("age","14");
    }

    @Test
    void hset(){
        HashOperations<String, Object, Object> ops = redisTemplate.opsForHash();
        ops.put("info","b","bb");
    }

    @Test
    void get(){
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        Object age = ops.get("age");
        System.out.println(age);
    }

    @Test
    void hget(){
        HashOperations<String, Object, Object> ops = redisTemplate.opsForHash();
        Object o = ops.get("info", "b");
        System.out.println(o);
    }
}
