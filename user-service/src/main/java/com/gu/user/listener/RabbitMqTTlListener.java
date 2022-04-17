package com.gu.user.listener;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.gu.user.pojo.User;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqTTlListener {
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "queueTTL"),
            exchange = @Exchange(value = "dealExChange",type = ExchangeTypes.DIRECT),
            key = {"dead"}
    ))
    public void listendead(String msg) throws InterruptedException {
        System.err.println("spring 死性队列接收到消息："+ JSONObject.parseObject(msg, User.class));
    }
/*    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "ttl_direct_queue",arguments = {
                    @Argument(name = "x-message-ttl",value = "1000",type = "java.lang.Integer"),
                    @Argument(name = "x-dead-letter-exchange",value = "dealExChange"),
                    @Argument(name = "x-dead-letter-routing-key",value = "dead")
            }),exchange = @Exchange("ttl_direct_exchange"),key = "ttlmessage")
    )
    public void listenttldirect(String msg) throws InterruptedException {
        System.err.println("spring 测试ttl队列接收到消息：【" + msg + "】");
        Thread.sleep(500);
    }*/
}
