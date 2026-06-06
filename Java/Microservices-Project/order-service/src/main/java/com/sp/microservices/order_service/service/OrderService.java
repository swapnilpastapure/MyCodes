package com.sp.microservices.order_service.service;

import com.sp.microservices.order_service.model.Order;
import com.sp.microservices.order_service.repository.OrderRepository;
import com.sp.microservices.order_service.service.dto.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {

        //mapping orderRequest to Order object
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setQuantity(orderRequest.quantity());
        order.setSkuCode(orderRequest.skuCode());


        //save order to OrderRepository
        orderRepository.save(order);

    }
}
