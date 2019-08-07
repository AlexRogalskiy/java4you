package com.sensiblemetrics.api.alpenidos.core.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation that is used to indicate that a method should be
 * wrapped by a {@link org.fishwife.jrugged.PerformanceMonitor}.  The value
 * passed to the annotation serves as a key for a PerformanceMonitor instance.
 * You may have a unique PerformanceMonitor for individual methods by using
 * unique key names in the PerformanceMonitor annotation for the method, or you
 * may share a PerformanceMonitor across classes and methods by using the
 * same key value for many PerformanceMonitor annotations.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface PerformanceMonitor {
    /**
     * The value for the configured
     * {@link org.fishwife.jrugged.PerformanceMonitor}.
     * @return the value.
     */
    String value();
}
