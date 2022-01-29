package com.kmitl.kmitl.controller;

import com.kmitl.kmitl.dto.ProductDto;
import com.kmitl.kmitl.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("admin/product")
    public ProductDto postProduct(@RequestBody ProductDto productDto){
        return productService.saveProduct(productDto);
    }

    @GetMapping("admin/products")
    public List<ProductDto> getProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("admin/product/{id}")
    public ProductDto findProduct(@PathVariable String id){
        return productService.findProduct(id);
    }
}
