package com.sensiblemetrics.api.alpenidos.core.aggregator.inventory_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller providing endpoints to retrieve product inventories
 */
@RestController
public class InventoryController {

    /**
     * Endpoint to retrieve a product's inventories.
     *
     * @return product inventory.
     */
    @GetMapping("/inventories")
    public int getProductInventories() {
        return 5;
    }
}
