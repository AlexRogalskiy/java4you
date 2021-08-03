package com.sensiblemetrics.api.alpenidos.pattern.layers.dao;

import com.sensiblemetrics.api.alpenidos.pattern.layers.model.CakeLayer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CRUD repository for cake layers
 */
@Repository
public interface CakeLayerDao extends CrudRepository<CakeLayer, Long> {
}
