package com.demo.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: shijing
 * @create: 2020-05-31 15:09
 **/
@Configuration
@MapperScan({"com.demo.springcloud.alibaba.dao"})
public class MyBatisConfig {
}
