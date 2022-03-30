package com.gu.orderservice.service;

import com.gu.orderservice.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("userservice")
@RequestMapping("/user")
public interface UserServicr {
    @GetMapping("/{id}")
    User queryById(@PathVariable("id") Long id);
}
/*
@FeignClient("discoveryServer")
@RequestMapping("/ds")
public interface IDiscoveryServer {

    @GetMapping("/hello")
    String hello();
}*/
