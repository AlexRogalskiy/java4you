//package com.sensiblemetrics.api.alpenidos.core.aggregator.aggregator_service.impl;
//
//import com.sensiblemetrics.api.alpenidos.core.aggregator.aggregator_service.iface.ProductInformationClient;
//import com.sensiblemetrics.api.alpenidos.core.aggregator.aggregator_service.iface.ProductInventoryClient;
//import com.sensiblemetrics.api.alpenidos.core.aggregator.aggregator_service.model.Product;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//
///**
// * The aggregator aggregates calls on various micro-services, collects
// * data and further publishes them under a REST endpoint.
// */
//@RestController
//public class Aggregator {
//
//
//    @Resource
//    private ProductInformationClient informationClient;
//
//    @Resource
//    private ProductInventoryClient inventoryClient;
//
//    /**
//     * Retrieves product data.
//     *
//     * @return a Product.
//     */
//    @RequestMapping("/product")
//    public Product getProduct() {
//        Product product = new Product();
//        product.setTitle(informationClient.getProductTitle());
//        product.setProductInventories(inventoryClient.getProductInventories());
//        return product;
//    }
//}
