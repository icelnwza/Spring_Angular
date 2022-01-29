package com.kmitl.kmitl.mapper;

import com.kmitl.kmitl.dto.ProductDto;
import com.kmitl.kmitl.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto mapToProductDto(Product product);

    List<ProductDto> mapToProductDtoList(List<Product> products);

    Product mapToProduct(ProductDto productDto);
}
