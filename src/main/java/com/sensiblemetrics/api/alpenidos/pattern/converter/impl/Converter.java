package com.sensiblemetrics.api.alpenidos.pattern.converter.impl;

import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Generic converter, thanks to Java8 features not only provides a way of generic bidirectional
 * conversion between corresponding types, but also a common way of converting a collection of objects
 * of the same type, reducing boilerplate code to the absolute minimum.
 *
 * @param <T> DTO representation's type
 * @param <U> Domain representation's type
 */
@RequiredArgsConstructor
public class Converter<T, U> {
    private final Function<T, U> fromDto;
    private final Function<U, T> fromEntity;

    /**
     * @param dto DTO entity
     * @return The domain representation - the result of the converting function application on dto entity.
     */
    public final U convertFromDto(final T dto) {
        return this.fromDto.apply(dto);
    }

    /**
     * @param entity domain entity
     * @return The DTO representation - the result of the converting function application on domain entity.
     */
    public final T convertFromEntity(final U entity) {
        return this.fromEntity.apply(entity);
    }

    /**
     * @param dtos collection of DTO entities
     * @return List of domain representation of provided entities retrieved by
     * mapping each of them with the conversion function
     */
    public final List<U> createFromDtos(final Collection<T> dtos) {
        return Optional.ofNullable(dtos).orElse(Collections.emptyList()).stream().map(this::convertFromDto).collect(Collectors.toList());
    }

    /**
     * @param entities collection of domain entities
     * @return List of domain representation of provided entities retrieved by
     * mapping each of them with the conversion function
     */
    public final List<T> createFromEntities(final Collection<U> entities) {
        return Optional.ofNullable(entities).orElse(Collections.emptyList()).stream().map(this::convertFromEntity).collect(Collectors.toList());
    }
}
