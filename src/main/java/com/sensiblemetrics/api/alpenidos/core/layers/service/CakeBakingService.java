package com.sensiblemetrics.api.alpenidos.core.layers.service;

import com.sensiblemetrics.api.alpenidos.core.layers.exception.CakeBakingException;
import com.sensiblemetrics.api.alpenidos.core.layers.dto.CakeInfo;
import com.sensiblemetrics.api.alpenidos.core.layers.dto.CakeLayerInfo;
import com.sensiblemetrics.api.alpenidos.core.layers.dto.CakeToppingInfo;

import java.util.List;

/**
 * Service for cake baking operations
 */
public interface CakeBakingService {

    /**
     * Bakes new cake according to parameters
     */
    void bakeNewCake(final CakeInfo cakeInfo) throws CakeBakingException;

    /**
     * Get all cakes
     */
    List<CakeInfo> getAllCakes();

    /**
     * Store new cake topping
     */
    void saveNewTopping(final CakeToppingInfo toppingInfo);

    /**
     * Get available cake toppings
     */
    List<CakeToppingInfo> getAvailableToppings();

    /**
     * Add new cake layer
     */
    void saveNewLayer(final CakeLayerInfo layerInfo);

    /**
     * Get available cake layers
     */
    List<CakeLayerInfo> getAvailableLayers();
}
