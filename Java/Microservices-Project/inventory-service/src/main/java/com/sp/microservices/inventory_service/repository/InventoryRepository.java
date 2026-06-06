package com.sp.microservices.inventory_service.repository;

import com.sp.microservices.inventory_service.model.inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<inventory, Long> {
     boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, Integer quantity);
}
