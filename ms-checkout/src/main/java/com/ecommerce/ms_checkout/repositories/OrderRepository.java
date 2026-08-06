package com.ecommerce.ms_checkout.repositories;

import com.ecommerce.ms_checkout.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
