package com.solin.wxsell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) //设置不使用数据库
public class WxsellApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxsellApplication.class, args);
    }

}
