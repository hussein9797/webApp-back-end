package com.example.demo.RabbitMQ;

import com.rabbitmq.client.impl.AMQImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {

public final static String  QUEUE="Estates_queue";
public final static String  EXCHANGE="Estates_Management_Exchange";
public final static String  ROUTING_KEY="Estates_Routing_key";
    private static final Logger logger = LoggerFactory.getLogger(MessageConfig.class);

    @Bean
    public Queue queue(){

        return  new Queue(QUEUE);
    }
    @Bean
    public TopicExchange exchange(){

        return  new TopicExchange(EXCHANGE);


    }
    @Bean
    public Binding binding(Queue queue,TopicExchange exchange){

        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

}
