package com.sensiblemetrics.api.alpenidos.pattern.api_gateway.image_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Exposes the Image microservice's endpoints
 */
@RestController
public class ImageController {

    /**
     * An endpoint for a user to retrieve an image path
     *
     * @return An image path
     */
    @GetMapping("/image-path")
    public String getImagePath() {
        return "/product-image.png";
    }
}
