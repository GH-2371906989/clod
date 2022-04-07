package com.gu.test.web;

import com.gu.test.config.logs.LogApi;
import com.gu.test.pojo.Order;
import com.gu.test.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RefreshScope
@LogApi(logParameters = true)
public class OrderController {
    @Value("${user.password}")
    private String password;
    @Autowired
    private OrderService orderService;

    @GetMapping("/password")
    public String getName(){
        return password;
    }

    @GetMapping("{orderId}")
    public Order queryOrderByUserId(@PathVariable("orderId") Long orderId) {
        // 根据id查询订单并返回
        return orderService.queryOrderById(orderId);
    }


}
