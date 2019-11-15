package com.solin.wxsell.controller;

import com.solin.wxsell.pojo.Student;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;


@RestController
@Api(tags = "Hello Swagger2,模块 ")
public class HelleWorldController {

    private final Logger log = LoggerFactory.getLogger(HelleWorldController.class);


    @ApiOperation("@PathVariable 路径参数参数测试")

    @PostMapping("hello/{name}")
    public String hello(@ApiParam(name = "name",value = "名字",defaultValue = "solin") @PathVariable String name) {
        return "i am " + name;
    }

    @ApiOperation("@RequestParam 表单参数获取")
    @GetMapping("query")
    public Student query(@RequestParam String param) {

        return  new Student("solin",12,176.5,75.5);
    }
    @ApiOperation("@RequestBody 表单参数获取")
    @PostMapping("addStu")
    public String addStu( @ApiParam(name="学生对象",value="json格式",required=true) @RequestBody  Student stu) {
        return "success";
    }

    @ApiOperation("exception 全局异常抓取测试")
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
