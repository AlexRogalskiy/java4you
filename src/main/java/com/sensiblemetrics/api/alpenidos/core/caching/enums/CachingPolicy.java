package com.sensiblemetrics.api.alpenidos.core.caching.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum class containing the four caching strategies implemented in the pattern.
 */
@Getter
@RequiredArgsConstructor
public enum CachingPolicy {
    THROUGH("through"),
    AROUND("around"),
    BEHIND("behind"),
    ASIDE("aside");

    private final String policy;
}
