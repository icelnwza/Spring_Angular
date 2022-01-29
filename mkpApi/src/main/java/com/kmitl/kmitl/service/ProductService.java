package com.kmitl.kmitl.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kmitl.kmitl.dto.ProductDto;
import com.kmitl.kmitl.entity.Product;
import com.kmitl.kmitl.mapper.ProductMapper;
import com.kmitl.kmitl.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ObjectMapper objectMapper;

    public ProductDto saveProduct(ProductDto productDto){
//        Product product = new Product();
//        product.setId(productDto.getId());
//        product.setName(productDto.getName());
//        product.setDescription(productDto.getDescription());
//        product.setPrice(productDto.getPrice());
          Product product  = productMapper.mapToProduct(productDto);
//        objectMapper.disable(MapperFeature.USE_ANNOTATIONS);
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        product = objectMapper.convertValue(productDto,Product.class);
//        objectMapper.enable(MapperFeature.USE_ANNOTATIONS);
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        productRepository.save(product);

        return productDto;
    }

    public List<ProductDto> getAllProducts(){
        List<Product> products = productRepository.findAll();
//
//        List<ProductDto> productDtoList = new ArrayList<>();
//        ProductDto productDtoResponse = new ProductDto();
//
//        for (Product item: products) {
//            productDtoResponse.setId(item.getId());
//            productDtoResponse.setName(item.getName());
//            productDtoResponse.setDescription(item.getDescription());
//            productDtoResponse.setPrice(item.getPrice());
//            productDtoResponse.setStatus(item.getStatus());
//            productDtoList.add(productDtoResponse);
//        }
//
        return  productMapper.mapToProductDtoList(products);


    }


    public ProductDto findProduct(String id){
        Product product = productRepository.findById(id).get();

//        ProductDto productDtoResponse = new ProductDto();
//        productDtoResponse.setId(product.getId());
//        productDtoResponse.setName(product.getName());
//        productDtoResponse.setDescription(product.getDescription());
//        productDtoResponse.setPrice(product.getPrice());
//        productDtoResponse.setStatus(product.getStatus());
//        return productDtoResponse;
        return productMapper.mapToProductDto(product);

    }

}
