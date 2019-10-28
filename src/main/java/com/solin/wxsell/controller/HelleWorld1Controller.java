package com.solin.wxsell.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("c1")
public class HelleWorld1Controller {

    @GetMapping("hello/{name}")
    public String hello(@PathVariable String name) {
        return "i am " + name;
    }
    @GetMapping("query")
    public String query(@RequestParam String param) {
        return  param;
    }

    @GetMapping("/exception")
    public String exception(){
//        String a = null;
        return (1/0)+"";
    }

}
