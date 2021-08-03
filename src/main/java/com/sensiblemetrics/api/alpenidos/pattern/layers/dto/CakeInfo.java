package com.sensiblemetrics.api.alpenidos.pattern.layers.dto;

import java.util.List;
import java.util.Optional;

/**
 * DTO for cakes
 */
public class CakeInfo {
    public Optional<Long> id;
    public CakeToppingInfo cakeToppingInfo;
    public List<CakeLayerInfo> cakeLayerInfos;

    /**
     * Constructor
     */
    public CakeInfo(final Long id, final CakeToppingInfo cakeToppingInfo, final List<CakeLayerInfo> cakeLayerInfos) {
        this.id = Optional.ofNullable(id);
        this.cakeToppingInfo = cakeToppingInfo;
        this.cakeLayerInfos = cakeLayerInfos;
    }

    /**
     * Constructor
     */
    public CakeInfo(final CakeToppingInfo cakeToppingInfo, final List<CakeLayerInfo> cakeLayerInfos) {
        this(null, cakeToppingInfo, cakeLayerInfos);
    }

    /**
     * Calculate calories
     */
    public int calculateTotalCalories() {
        int total = this.cakeToppingInfo != null ? this.cakeToppingInfo.calories : 0;
        total += this.cakeLayerInfos.stream().mapToInt(c -> c.calories).sum();
        return total;
    }

    @Override
    public String toString() {
        return String.format("CakeInfo id=%d topping=%s layers=%s totalCalories=%d", this.id.orElse(-1L), this.cakeToppingInfo, this.cakeLayerInfos, this.calculateTotalCalories());
    }
}
