package com.sp.microservices.order_service.service;

import com.sp.microservices.order_service.client.InventoryClient;
import com.sp.microservices.order_service.model.Order;
import com.sp.microservices.order_service.repository.OrderRepository;
import com.sp.microservices.order_service.dto.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public void placeOrder(OrderRequest orderRequest) {


        // 1.using Mockito
        // 2. use wiremock
      var isProductInStock =  inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());

      if(isProductInStock){
          //mapping orderRequest to Order object
          Order order = new Order();
          order.setOrderNumber(UUID.randomUUID().toString());
          order.setPrice(orderRequest.price());
          order.setQuantity(orderRequest.quantity());
          order.setSkuCode(orderRequest.skuCode());
          //save order to OrderRepository
          orderRepository.save(order);
      }else {
            throw new RuntimeException("Product with SKU code " + orderRequest.skuCode() + " is not in stock");
      }



    }
}
