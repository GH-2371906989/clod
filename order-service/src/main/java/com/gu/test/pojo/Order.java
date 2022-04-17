package com.gu.test.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.gu.feign.pojo.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@TableName(value = "tb_order")
public class Order {
    private Long id;
    private Long price;
    private String name;
    private Integer num;
    private Long userId;
    private User user;
}