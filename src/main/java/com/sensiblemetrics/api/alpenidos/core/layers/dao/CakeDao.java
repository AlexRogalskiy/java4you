package com.sensiblemetrics.api.alpenidos.core.layers.dao;

import com.sensiblemetrics.api.alpenidos.core.layers.model.Cake;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CRUD repository for cakes
 */
@Repository
public interface CakeDao extends CrudRepository<Cake, Long> {
}
