package com.example.inventory_service.Service;

import com.example.inventory_service.repository.inventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Service
public class inventoryService {
    private final inventoryRepository inventoryRepo ;

    public boolean isInStock(String skuCode,Integer quantity){
        return inventoryRepo.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode,quantity);
    }

}
