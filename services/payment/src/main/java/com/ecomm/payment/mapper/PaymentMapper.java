package com.ecomm.payment.mapper;

import com.ecomm.payment.dto.PaymentRequest;
import com.ecomm.payment.entity.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {
    public Payment map(PaymentRequest paymentRequest){

        return new Payment(
                null,
                paymentRequest.getPaymentMethod(),
                paymentRequest.getAmount(),
                paymentRequest.getOrderId()
        );
    }
}
