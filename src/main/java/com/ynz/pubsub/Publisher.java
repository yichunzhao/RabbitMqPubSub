package com.ynz.pubsub;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class Publisher implements CommandLineRunner {
    private final RabbitTemplate rabbitTemplate;
    private final Subscriber subscriber;

    public Publisher(RabbitTemplate rabbitTemplate, Subscriber subscriber) {
        this.rabbitTemplate = rabbitTemplate;
        this.subscriber = subscriber;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("publisher sending message ");
        rabbitTemplate.convertAndSend(DemoRabbitPubSub.topicExchangeName,
                DemoRabbitPubSub.routingKey, "hello from Rabbit Mq!");

        subscriber.getLatch().await(10000, TimeUnit.MILLISECONDS);

    }
}
