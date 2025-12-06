package com.ecomm.notification.kafka.order;

import com.ecomm.notification.kafka.OrderConfirmation;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderConsumer {
    //    Consume payment-topic
    @KafkaListener(topics = "order-topic",groupId = "orderGroup")
    public void consumeOrder(OrderConfirmation orderConfirmation){

    }
}
