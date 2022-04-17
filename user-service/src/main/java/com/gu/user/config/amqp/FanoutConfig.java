package com.gu.user.config.amqp;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.management.Query;

@Configuration
public class FanoutConfig {
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanout");
    }
    @Bean
    public Queue fanoutQueue1(){
        return new Queue("queue1");
    }
    @Bean
    public Queue fanoutQueue2(){
        return new Queue("queue2");
    }
    @Bean
    public Binding queue1Binding(){
        return BindingBuilder.bind(fanoutQueue1()).to(fanoutExchange());
    }
    @Bean
    public Binding queue2Binding(){
        return BindingBuilder.bind(fanoutQueue2()).to(fanoutExchange());
    }

}
