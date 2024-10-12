package com.microservice_prj.order_service.Repository;

import com.microservice_prj.order_service.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface orderRepository extends JpaRepository<Order, Long> {
}
