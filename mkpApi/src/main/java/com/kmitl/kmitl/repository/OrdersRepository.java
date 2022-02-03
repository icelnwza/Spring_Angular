package com.kmitl.kmitl.repository;

import com.kmitl.kmitl.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,String> {
}
