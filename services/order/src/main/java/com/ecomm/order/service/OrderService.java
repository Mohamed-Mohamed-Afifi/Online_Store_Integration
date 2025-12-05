package com.ecomm.order.service;

import com.ecomm.order.clients.customer.CustomerClient;
import com.ecomm.order.clients.payment.Customer;
import com.ecomm.order.clients.payment.PaymentClient;
import com.ecomm.order.clients.payment.PaymentRequest;
import com.ecomm.order.clients.product.ProductClient;
import com.ecomm.order.dao.OrderLineRepo;
import com.ecomm.order.dao.OrderRepo;
import com.ecomm.order.entity.OrderEntity;
import com.ecomm.order.entity.OrderLine;
import com.ecomm.order.entity.OrderRequest;
import com.ecomm.order.entity.PurchaseRequest;
import com.ecomm.order.kafka.OrderConfirmation;
import com.ecomm.order.kafka.OrderProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CustomerClient customerClient;
    private final OrderRepo orderRepo;
    private final OrderLineRepo orderLineRepo;
    private final ProductClient productClient;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;
    public OrderEntity createOrder(OrderRequest order) {
//        Check Customer is exist using OpenFeign
        var customer=customerClient.findCustomerById(order.getCustomerId()).orElseThrow(()->new RuntimeException("cant not create order"));
//        Purchase products
        var purchaseResponses=productClient.purchaseRequests(order.getPurchaseRequests());
//        presist Order
        OrderEntity order1=new OrderEntity();
        order1.setReference(order.getReference());
//        order1.setId(order.getId());
        order1.setCustomerId(order.getCustomerId());
        order1.setTotalAmount(order.getTotalAmount());
        order1.setPaymentMethod(order.getPaymentMethod());
       OrderEntity PresistedOrederOrder2= orderRepo.save(order1);
//        presist orderline
        for(PurchaseRequest purchaseRequest:order.getPurchaseRequests()){
            OrderLine orderLine=new OrderLine();
            orderLine.setQuantity(purchaseRequest.getQuantity());
            orderLine.setProduct_id(purchaseRequest.getProductId());
            orderLine.setOrder(order1);
            orderLineRepo.save(orderLine);
        }
//        Start Payment
        Customer customer1=new Customer();
        customer1.setAge(customer.getAge());
        customer1.setId(customer.getId());
        customer1.setName(customer.getName());
        customer1.setEmail(customer.getEmail());
        var paymentResponse=paymentClient.requestOrderPayment(
                new PaymentRequest(null, order.getTotalAmount(),order.getPaymentMethod(),order.getId(),order.getReference(),customer1)
        );
//        Send Order Confiramtion to notification sercice (Kafka)
        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        order.getReference(),
                        order.getTotalAmount(),
                        order.getPaymentMethod(),
                        customer,
                        purchaseResponses

                )
        );
        return PresistedOrederOrder2;
    }

    public OrderEntity findOrderById(Integer id) {
        return orderRepo.findById(id).get();
    }
}
