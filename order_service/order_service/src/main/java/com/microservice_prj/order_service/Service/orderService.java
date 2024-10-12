package com.microservice_prj.order_service.Service;

import com.microservice_prj.order_service.Model.Order;
import com.microservice_prj.order_service.Repository.orderRepository;
import com.microservice_prj.order_service.dto.OrderRequest;
import com.microservice_prj.order_service.client.InventoryClient;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class orderService {

    private final orderRepository OrderRepo;
    private final InventoryClient InventoryClient;

    public void placeOrder(OrderRequest orderRequest){
        var isProductInStock = InventoryClient.isInStock(orderRequest.skuCode(),orderRequest.quantity());
        if(isProductInStock){
            Order order = new Order();
            order.setOderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price());
            order.setSkuCode(orderRequest.skuCode());
            order.setQuantity(orderRequest.quantity());
            OrderRepo.save(order);
            log.info("Order Placed Successfully "+orderRequest);
        }else{
            throw new RuntimeException("Product with code " + orderRequest.skuCode() + " is not in stock");
        }
    }
}
