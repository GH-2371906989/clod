package com.gu.test;

import com.alibaba.fastjson.JSON;
import com.gu.feign.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrderServiceApplicationTests {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    void contextLoads() throws InterruptedException {
        rabbitTemplate.convertAndSend("Direct.Exchange","d3","超级大傻逼");
    }
    @Test
    void contextLoads1() throws InterruptedException {
        for (int i=0;i<50;i++){
            rabbitTemplate.convertAndSend("queue1","hello word"+i);
            Thread.sleep(20);
        }
    }

    @Test
    void contextttl() throws InterruptedException {
        for (int i=0;i<10;i++){
            rabbitTemplate.convertAndSend("ttl_direct_exchange","ttlmessage","hello word"+i);
        }
    }

    @Test
    void contextttl1() throws InterruptedException {
        User user = User.builder()
                .id(1L)
                .username("张三")
                .address("河北石家庄")
                .build();
        rabbitTemplate.convertAndSend("ttl_direct_exchange","ttlmessage", JSON.toJSONString(user));
    }

}
