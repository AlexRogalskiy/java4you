package com.sensiblemetrics.api.alpenidos.pattern.caching.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class (stored in cache and DB) used in the application.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAccount {
    private String userId;
    private String userName;
    private String additionalInfo;
}
