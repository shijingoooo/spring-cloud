package com.demo.springcloud.alibaba.controller;

import com.demo.springcloud.alibaba.domain.CommonResult;
import com.demo.springcloud.alibaba.domain.Order;
import com.demo.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program:
 * @description:
 * @author: shijing
 * @create: 2020-05-31 15:06
 **/
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order) {

        orderService.create(order);
        return new CommonResult(200, "订单创建完成");
    }

}
