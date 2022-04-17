package com.gu.test.service;


import com.gu.common.exception.BusinessException;
import com.gu.feign.client.UserClient;
import com.gu.feign.pojo.User;
import com.gu.test.mapper.OrderMapper;
import com.gu.test.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserClient userClient;

    @Autowired
    private RestTemplate 不需要猪肉吧;



    public Order queryOrderById(Long orderId) {
/*        if (orderId != 101){
            throw  new BusinessException("不是101");
        }*/
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // 2.1.url路径
        User user = userClient.findById(order.getUserId());
        // 3.封装user到Order
        order.setUser(user);
        // 4.返回
        return order;
    }

    @Transactional
    public Integer transUpdate() {
        Order order = Order.builder()
                .id(109L)
                .name("333")
                .build();
        int updateById = orderMapper.updateById(order);
        try {
            User byId = userClient.findById(1L);
        }catch (Exception e){
            throw new BusinessException("404");
        }
        return updateById;
    }
}
