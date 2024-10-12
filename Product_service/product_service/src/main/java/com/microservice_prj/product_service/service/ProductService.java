package com.microservice_prj.product_service.service;

import com.microservice_prj.product_service.Model.Product;
import com.microservice_prj.product_service.Repository.ProductRepository;
import com.microservice_prj.product_service.dto.ProductRequest;
import com.microservice_prj.product_service.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product newProduct = Product.builder().name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
        productRepository.save(newProduct);
        log.info("New product created successfully");

        return new ProductResponse(newProduct.getId(),newProduct.getName(),newProduct.getDescription(),newProduct.getPrice());
    }

    public List<ProductResponse> getAllProduct() {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(product.getId(),product.getName(),product.getDescription(),product.getPrice())).toList();
    }
}
