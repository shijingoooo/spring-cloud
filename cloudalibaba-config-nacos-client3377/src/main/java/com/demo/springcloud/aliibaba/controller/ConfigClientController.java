package com.demo.springcloud.aliibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: shijing
 * @create: 2020-04-16 22:51
 **/
@RestController
@RefreshScope  // 支持Nacos动态刷新功能
public class ConfigClientController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${profile}")
    private String configInfo;

    @GetMapping("/config")
    public String getConfigInfo() {
        return "serverPort: " + serverPort + "\t" + "configInfo: " + configInfo;
    }

}
