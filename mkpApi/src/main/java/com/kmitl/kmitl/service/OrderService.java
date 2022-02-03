package com.kmitl.kmitl.service;

import com.kmitl.kmitl.dto.OrdersDto;
import com.kmitl.kmitl.entity.Orders;
import com.kmitl.kmitl.entity.Product;
import com.kmitl.kmitl.mapper.OrderMapper;
import com.kmitl.kmitl.repository.OrdersRepository;
import com.kmitl.kmitl.repository.ProductRepository;
import com.kmitl.kmitl.util.UUIDGenerator;
import lombok.RequiredArgsConstructor;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private OrdersRepository ordersRepository;
    private final OrderMapper orderMapper;
    private final ProductRepository productRepository;

    public OrdersDto saveOrder(OrdersDto ordersDto){

        Orders orders = orderMapper.toOrder(ordersDto);
        orders.setTotalAmount(
                orders.getOrderDetails().stream().mapToDouble(od -> {
                    Product product = productRepository.findById(od.getProduct().getId()).get();
                    od.setPrice(product.getPrice());
                    return product.getPrice();
                }).sum()
        );
        orders.getOrderDetails().forEach(od -> od.setOrder(orders));
        ordersRepository.save(orders);
        return ordersDto;
    }
}
