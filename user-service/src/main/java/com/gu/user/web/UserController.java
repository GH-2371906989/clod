package com.gu.user.web;

import com.gu.user.config.logs.LogApi;
import com.gu.user.pojo.User;
import com.gu.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RefreshScope
@LogApi(logParameters = true )
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${user.name}")
    private String name;

    @GetMapping("/name")
    public String getName(){
        return name;
    }

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }

}
