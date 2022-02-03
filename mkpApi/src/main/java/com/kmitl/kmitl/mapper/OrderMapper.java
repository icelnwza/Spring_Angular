package com.kmitl.kmitl.mapper;

import com.kmitl.kmitl.dto.OrderDetailDto;
import com.kmitl.kmitl.dto.OrdersDto;
import com.kmitl.kmitl.entity.OrderDetail;
import com.kmitl.kmitl.entity.Orders;
import com.kmitl.kmitl.util.UUIDGenerator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring",imports = {UUIDGenerator.class})
public interface OrderMapper {

    @Mapping(target = "id",
            expression = "java(ordersDto.getId().isEmpty()? UUIDGenerator.getUUID():ordersDto.getId())")
    Orders toOrder(OrdersDto ordersDto);

//    @Mapping(target = "id",
//            source = "id",
//            expression = "UUIDGenerator.getUUID()")
//    @Mapping(target = "product.id",source = "productId")
//    OrderDetail toOrderDetail(OrderDetailDto orderDetailDto);
}
