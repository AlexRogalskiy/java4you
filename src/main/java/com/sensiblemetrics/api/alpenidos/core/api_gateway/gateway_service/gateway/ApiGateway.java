//package com.sensiblemetrics.api.alpenidos.core.api_gateway.gateway_service;
//
//import com.sensiblemetrics.api.alpenidos.core.api_gateway.gateway_service.iface.ImageClient;
//import com.sensiblemetrics.api.alpenidos.core.api_gateway.gateway_service.iface.PriceClient;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//
///**
// * The ApiGateway aggregates calls to microservices based on the needs of the individual clients.
// */
//@RestController
//public class ApiGateway {
//
//    @Resource
//    private ImageClient imageClient;
//
//    @Resource
//    private PriceClient priceClient;
//
//    /**
//     * Retrieves product information that desktop clients need
//     *
//     * @return Product information for clients on a desktop
//     */
//    @RequestMapping("/desktop")
//    public DesktopProduct getProductDesktop() {
//        final DesktopProduct desktopProduct = new DesktopProduct();
//        desktopProduct.setImagePath(imageClient.getImagePath());
//        desktopProduct.setPrice(priceClient.getPrice());
//        return desktopProduct;
//    }
//
//    /**
//     * Retrieves product information that mobile clients need
//     *
//     * @return Product information for clients on a mobile device
//     */
//    @RequestMapping("/mobile")
//    public MobileProduct getProductMobile() {
//        final MobileProduct mobileProduct = new MobileProduct();
//        mobileProduct.setPrice(priceClient.getPrice());
//        return mobileProduct;
//    }
//}
