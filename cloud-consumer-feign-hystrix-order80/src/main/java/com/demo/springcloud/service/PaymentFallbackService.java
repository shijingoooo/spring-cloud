package com.demo.springcloud.service;

import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: shijing
 * @create: 2020-04-13 20:15
 **/
@Service
public class PaymentFallbackService implements PaymentHystrixService{

    @Override
    public String paymentInfoOk(Integer id) {
        return "PaymentFallbackService-paymentInfoOk fall back";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "PaymentFallbackService-paymentInfoTimeout fall back";
    }
}
