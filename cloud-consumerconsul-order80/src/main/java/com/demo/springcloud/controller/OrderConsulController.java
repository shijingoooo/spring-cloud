package com.demo.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @description:
 * @author: shijing
 * @create: 2020-04-11 14:53
 **/
@RestController
@Slf4j
public class OrderConsulController {

    public static final String PAYMENT_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String info() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/consul", String.class);
    }
}
