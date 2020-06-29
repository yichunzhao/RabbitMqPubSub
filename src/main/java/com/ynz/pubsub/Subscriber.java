package com.ynz.pubsub;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class Subscriber {
    private CountDownLatch latch = new CountDownLatch(3);

    public void receiveMessage(String message) {
        System.out.println("Received:  " + message);
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
