package com.gu.user.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import javax.lang.model.type.ExecutableType;

@Component
public class RabbitMqListener {
/*    @RabbitListener(queues = "queue1")
    public void listenSimpleQueueMessage(String msg) throws InterruptedException {
        System.out.println("spring 消费者接收到消息：【" + msg + "】");
    }*/
    @RabbitListener(queues = "queue1")
    public void listenSimpleQueue1Message(String msg) throws InterruptedException {
        System.out.println("spring 消费者1接收到消息：【" + msg + "】");
    }
    @RabbitListener(queues = "queue2")
    public void listenSimpleQueue2Message(String msg) throws InterruptedException {
        System.err.println("spring 消费者2接收到消息：【" + msg + "】");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("Direct.queue1"),
            exchange = @Exchange(name = "Direct.Exchange",type = ExchangeTypes.DIRECT),
            key = {"d1","d3"}
    ))
    public void listenDirect1(String msg) throws InterruptedException {
        System.err.println("spring 消费者1接收到消息：【" + msg + "】");
    }
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("Direct.queue2"),
            exchange = @Exchange(name = "Direct.Exchange",type = ExchangeTypes.DIRECT),
            key = {"d2","d3"}
    ))
    public void listenDirect2(String msg) throws InterruptedException {
        System.err.println("spring 消费者2接收到消息：【" + msg + "】");
    }


}

/*
**/