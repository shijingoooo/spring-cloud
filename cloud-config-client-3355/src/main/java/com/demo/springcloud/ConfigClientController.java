package com.demo.springcloud;

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
@RefreshScope
public class ConfigClientController {

    @Value("${profile}")
    private String config;

    @GetMapping("/config")
    public String getConfig() {
        return config;
    }

}
