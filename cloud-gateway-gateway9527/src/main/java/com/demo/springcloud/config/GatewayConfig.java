package com.demo.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 配置了一个id为path_route_demo的路由规则，
 *                  当访问地址http://localhost:9527/guonei时会自动转发到地址: http://news.baidu.com/guonei
 * @author: shijing
 * @create: 2020-04-15 21:56
 **/
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocate(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route_demo",
                r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }

}
