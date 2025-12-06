package com.ecomm.notification.kafka.payment;

import com.ecomm.notification.kafka.PaymentNotificationRequest;
import com.ecomm.notification.mail.MailSenderNotification;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentConsumer {
private final MailSenderNotification mailSender;
//    Consume payment-topic
    @KafkaListener(topics = "payment-topic",groupId = "paymentGroup")
    public void consumePayment(PaymentNotificationRequest paymentConfirmation) throws MessagingException {
    mailSender.sendPaymentInfo(paymentConfirmation.getCustomerEmail(), paymentConfirmation.getCustomerName(),paymentConfirmation.getAmount(), paymentConfirmation.getOrderReference());
    }
}
