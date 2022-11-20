package com.demo.springcloud.aliibaba.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.demo.springcloud.entities.CommonResult;
import com.demo.springcloud.entities.Payment;

/**
 * @description:
 * @author: shijing
 * @create: 2020-05-08 23:17
 **/
public class CustomerBlockHandler {

    public static CommonResult handlerException1(BlockException exception) {
        return new CommonResult(444, "按客户自定义,global handlerException---1");
    }

    public static String handlerException2(BlockException exception) {
        return "按客户自定义,global handlerException---2";
    }

}
