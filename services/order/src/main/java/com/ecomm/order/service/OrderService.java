package com.ecomm.order.service;

import com.ecomm.order.clients.customer.CustomerClient;
import com.ecomm.order.clients.product.ProductClient;
import com.ecomm.order.dao.OrderLineRepo;
import com.ecomm.order.dao.OrderRepo;
import com.ecomm.order.entity.Order;
import com.ecomm.order.entity.OrderLine;
import com.ecomm.order.entity.OrderRequest;
import com.ecomm.order.entity.PurchaseRequest;
import com.ecomm.order.kafka.OrderConfirmation;
import com.ecomm.order.kafka.OrderProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CustomerClient customerClient;
    private final OrderRepo orderRepo;
    private final OrderLineRepo orderLineRepo;
    private final ProductClient productClient;
    private final OrderProducer orderProducer;
    public Order createOrder(OrderRequest order) {
//        Check Customer is exist using OpenFeign
        var customer=customerClient.findCustomerById(order.getCustomerId()).orElseThrow(()->new RuntimeException("cant not create order"));
//        Purchase products
        var purchaseResponses=productClient.purchaseRequests(order.getPurchaseRequests());
//        presist Order
        Order order1=new Order();
        order1.setReference(order.getReference());
        order1.setId(order.getId());
        order1.setCustomerId(order.getCustomerId());
        order1.setTotalAmount(order.getTotalAmount());
        order1.setPaymentMethod(order.getPaymentMethod());
       Order PresistedOrederOrder2= orderRepo.save(order1);
//        presist orderline
        for(PurchaseRequest purchaseRequest:order.getPurchaseRequests()){
            OrderLine orderLine=new OrderLine();
            orderLine.setQuantity(purchaseRequest.getQuantity());
            orderLine.setProduct_id(purchaseRequest.getProduct_id());
            orderLine.setOrder(order1);
            orderLineRepo.save(orderLine);
        }
//        Start Payment
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

    public Order findOrderById(Integer id) {
        return orderRepo.findById(id).get();
    }
}
