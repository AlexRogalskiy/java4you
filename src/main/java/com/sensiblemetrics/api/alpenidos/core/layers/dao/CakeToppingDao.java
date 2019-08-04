package com.sensiblemetrics.api.alpenidos.core.layers.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CRUD repository cake toppings
 */
@Repository
public interface CakeToppingDao extends CrudRepository<CakeTopping, Long> {
}
