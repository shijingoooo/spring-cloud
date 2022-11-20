package com.demo.springcloud.aliibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.demo.springcloud.aliibaba.handler.CustomerBlockHandler;
import com.demo.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: shijing
 * @create: 2020-05-06 22:39
 **/
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    @SentinelResource(value = "testA"
            , blockHandlerClass = CustomerBlockHandler.class
            , blockHandler = "handlerException2")
    public String testA() {
        return "testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "testB";
    }

    @GetMapping("/testD")
    public String testD() throws InterruptedException {
//        TimeUnit.SECONDS.sleep(1);
//        log.info("testD...测试RT");

        log.info("testD 异常比例");
        int age = 10 / 0;
        return "testD";
    }

    @GetMapping("/testE")
    public String testE() {
        log.info("testE 异常数");
        int age = 10 / 0;
        return "testD";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "hotKeyBlockHandler")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1
            ,@RequestParam(value = "p1", required = false) String p2) {
        return "testHotKey";
    }

    public String hotKeyBlockHandler(String p1, String p2, BlockException exception) {
        // sentinel系统默认提示：Blocked by Sentinel（flow limiting）
        return "hotKeyBlockHandler";
    }

}
