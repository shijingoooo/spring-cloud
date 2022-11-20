package com.demo.springcloud.alibaba.service.impl;

import com.demo.springcloud.alibaba.dao.OrderDao;
import com.demo.springcloud.alibaba.domain.Order;
import com.demo.springcloud.alibaba.service.AccountService;
import com.demo.springcloud.alibaba.service.OrderService;
import com.demo.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program:
 * @description:
 * @author: shijing
 * @create: 2020-05-31 14:53
 **/
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    public void create(Order order) {
        log.info("-----> 开始新建订单");
        orderDao.create(order);

        log.info("-----> 订单微服务开始调用库存，做扣减Count");
        storageService.decrease(order.getProductId(), order.getCount());

        log.info("-----> 订单微服务开始调用账户，做扣减Money");
        accountService.decrease(order.getUserId(), order.getMoney());

        log.info("-----> 修改订单状态");
        orderDao.update(order.getUserId(), 0);

    }
}
