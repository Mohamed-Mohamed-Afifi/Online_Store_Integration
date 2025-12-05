package com.ecomm.payment.service;

import com.ecomm.payment.dao.PaymentRepo;
import com.ecomm.payment.dto.PaymentRequest;
import com.ecomm.payment.entity.Payment;
import com.ecomm.payment.kafka.NotificationProducer;
import com.ecomm.payment.kafka.PaymentNotificationRequest;
import com.ecomm.payment.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepo paymentRepo;
    private final PaymentMapper paymentMapper;
    private final NotificationProducer notificationProducer;
    public Payment createPayment(PaymentRequest payment){
        var paymentResponse=paymentRepo.save(paymentMapper.map(payment));
        notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        payment.getOrderReference(),
                        payment.getAmount(),
                        payment.getPaymentMethod(),
                        payment.getCustomer().getName(),
                        payment.getCustomer().getEmail()
                )
        );
        return paymentResponse;
    }
}
