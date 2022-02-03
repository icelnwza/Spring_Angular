package com.kmitl.kmitl.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrdersDto {
    private String id;
    private String name;
    private String address1;
    private String address2;
    private String address3;
    private List<OrderDetailDto> orderDetails;
    private Double totalAmount;
}
