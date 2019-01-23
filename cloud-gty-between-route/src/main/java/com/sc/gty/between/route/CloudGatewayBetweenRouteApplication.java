package com.sc.gty.between.route;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: cloud-master
 * @package: com.sc.gty.between.route、
 * @email: cy880708@163.com
 * @date: 2019/1/23 上午11:16
 * @mofified By:
 */
@SpringBootApplication
public class CloudGatewayBetweenRouteApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudGatewayBetweenRouteApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        ZonedDateTime dateTime1 = LocalDateTime.now().minusDays(1).atZone(ZoneId.systemDefault());
        ZonedDateTime dateTime2 = LocalDateTime.now().plusDays(1).atZone(ZoneId.systemDefault());
        return builder.routes()
                .route("before_route", r -> r.between(dateTime1, dateTime2)
                        .uri("http://baidu.com"))
                .build();
    }

}
