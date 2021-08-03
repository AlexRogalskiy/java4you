package com.sensiblemetrics.api.alpenidos.pattern.aggregator.aggregator_service.impl;

import com.sensiblemetrics.api.alpenidos.pattern.aggregator.aggregator_service.iface.ProductInformationClient;
import com.sensiblemetrics.api.alpenidos.pattern.aggregator.aggregator_service.iface.ProductInventoryClient;
import com.sensiblemetrics.api.alpenidos.pattern.aggregator.aggregator_service.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The aggregator aggregates calls on various micro-services, collects
 * data and further publishes them under a REST endpoint.
 */
@RestController
public class Aggregator {
    @Autowired
    private ProductInformationClient informationClient;

    @Autowired
    private ProductInventoryClient inventoryClient;

    /**
     * Retrieves product data.
     *
     * @return a Product.
     */
    @GetMapping("/product")
    public Product getProduct() {
        Product product = new Product();
        product.setTitle(informationClient.getProductTitle());
        product.setProductInventories(inventoryClient.getProductInventories());
        return product;
    }
}
