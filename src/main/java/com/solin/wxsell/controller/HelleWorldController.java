package com.solin.wxsell.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;


@RestController
public class HelleWorldController {

    private final Logger log = LoggerFactory.getLogger(HelleWorldController.class);
    @GetMapping("hello/{name}")
    public String hello(@PathVariable String name) {
        return "i am " + name;
    }
    @GetMapping("query")
    public String query(@RequestParam String param) {
        return  param;
    }

    @GetMapping("exception")
    public String exception(){
        String a = null;
        return a.toString();
    }

    @Autowired
    private StringRedisTemplate srt;

    @GetMapping("redisString")
    public Boolean redisString(@RequestParam String name ){
        return srt.opsForValue().setIfAbsent("name", name, 10, TimeUnit.SECONDS);
    }

@Autowired
private RedisTemplate redisTemplate;
    @GetMapping("redisTem")
    public String redisTem(@RequestParam String name ){
        HashMap<String,Object> stu = new HashMap<>();
        stu.put("name","李浪");
        stu.put("age",26);
        stu.put("gender","男");
        redisTemplate.opsForValue().set("student",stu);
        return "success";
    }


}
