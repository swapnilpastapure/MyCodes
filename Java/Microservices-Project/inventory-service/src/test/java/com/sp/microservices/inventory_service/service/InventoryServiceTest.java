package com.sp.microservices.inventory_service.service;

import com.sp.microservices.inventory_service.model.inventory;
import com.sp.microservices.inventory_service.repository.InventoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("Inventory Service Unit Tests")
class InventoryServiceTest {

    @Mock
    private InventoryRepository inventoryRepository;

    @InjectMocks
    private InventoryService inventoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should return true when inventory exists with sufficient quantity")
    void testIsInStock_WithSufficientQuantity() {
        // Arrange
        String skuCode = "iphone_15";
        Integer quantity = 10;
        when(inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity))
                .thenReturn(true);

        // Act
        boolean result = inventoryService.isInStock(skuCode, quantity);

        // Assert
        assertTrue(result);
        verify(inventoryRepository, times(1))
                .existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
    }

    @Test
    @DisplayName("Should return false when inventory doesn't exist or quantity is insufficient")
    void testIsInStock_WithInsufficientQuantity() {
        // Arrange
        String skuCode = "iphone_15";
        Integer quantity = 1000;
        when(inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity))
                .thenReturn(false);

        // Act
        boolean result = inventoryService.isInStock(skuCode, quantity);

        // Assert
        assertFalse(result);
        verify(inventoryRepository, times(1))
                .existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
    }

    @Test
    @DisplayName("Should return true when inventory has exactly the required quantity")
    void testIsInStock_WithExactQuantity() {
        // Arrange
        String skuCode = "samsung_s24";
        Integer quantity = 50;
        when(inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity))
                .thenReturn(true);

        // Act
        boolean result = inventoryService.isInStock(skuCode, quantity);

        // Assert
        assertTrue(result);
    }

    @Test
    @DisplayName("Should return true for zero quantity")
    void testIsInStock_WithZeroQuantity() {
        // Arrange
        String skuCode = "laptop_dell";
        Integer quantity = 0;
        when(inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity))
                .thenReturn(true);

        // Act
        boolean result = inventoryService.isInStock(skuCode, quantity);

        // Assert
        assertTrue(result);
    }

    @Test
    @DisplayName("Should return false for non-existent SKU code")
    void testIsInStock_WithNonExistentSkuCode() {
        // Arrange
        String skuCode = "non_existent_sku";
        Integer quantity = 1;
        when(inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity))
                .thenReturn(false);

        // Act
        boolean result = inventoryService.isInStock(skuCode, quantity);

        // Assert
        assertFalse(result);
    }
}

