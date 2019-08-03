package com.sensiblemetrics.api.alpenidos.core.data_transfer_object.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * {@link CustomerDto} is a data transfer object POJO. Instead of sending individual information to client
 * We can send related information together in POJO.
 * <p>
 * Dto will not have any business logic in it.
 */
@Data
@RequiredArgsConstructor
public class CustomerDto {
    private final String id;
    private final String firstName;
    private final String lastName;
}
