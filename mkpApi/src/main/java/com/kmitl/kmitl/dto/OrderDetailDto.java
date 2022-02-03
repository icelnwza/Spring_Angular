package com.kmitl.kmitl.dto;

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
import lombok.Data;

@Data
public class OrderDetailDto {
    private String id;
    private String productId;
    private Integer quantity;
    private Double price;
    private Double total;
    private String productName;




}
