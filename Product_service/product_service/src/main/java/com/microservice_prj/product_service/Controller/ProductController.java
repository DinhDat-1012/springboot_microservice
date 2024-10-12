package com.microservice_prj.product_service.Controller;

import com.microservice_prj.product_service.Model.Product;
import com.microservice_prj.product_service.dto.ProductRequest;
import com.microservice_prj.product_service.dto.ProductResponse;
import com.microservice_prj.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path ="/api/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest){
       return productService.createProduct(productRequest);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<ProductResponse> getAllProduct(){
        return productService.getAllProduct();
    }
}
