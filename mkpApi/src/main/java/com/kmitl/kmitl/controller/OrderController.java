package com.kmitl.kmitl.controller;


import com.kmitl.kmitl.dto.OrdersDto;
import com.kmitl.kmitl.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class OrderController{
    private final OrderService orderService;


    @PostMapping("order")
    public OrdersDto postOrder(@RequestBody OrdersDto ordersDto){
        return orderService.saveOrder(ordersDto);
    }

}
