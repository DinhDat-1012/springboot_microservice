package com.example.inventory_service.Controller;

import com.example.inventory_service.Service.inventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/inventory")
@RequiredArgsConstructor
public class inventoryController {
    private final inventoryService inventory_service;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam String skuCode,@RequestParam Integer quantity) {
       return inventory_service.isInStock(skuCode, quantity);
    }
}
