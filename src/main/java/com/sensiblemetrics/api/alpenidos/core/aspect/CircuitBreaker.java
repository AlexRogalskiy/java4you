package com.sensiblemetrics.api.alpenidos.core.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a method as one to be wrapped with a
 * {@link org.fishwife.jrugged.CircuitBreaker}.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CircuitBreaker {

    /**
     * Name of the circuit.  Each annotation with a shared value shares
     * the same CircuitBreaker.
     * @return the value
     */
    String name();

    /**
     * Exception types that the {@link
     * org.fishwife.jrugged.CircuitBreaker} will ignore (pass through
     * transparently without tripping).
     * @return the Exception types.
     */
    Class<? extends Throwable>[] ignore() default {};

    /**
     * Specifies the length of the measurement window for failure
     * tolerances in milliseconds.  i.e. if <code>limit</code>
     * failures occur within <code>windowMillis</code> milliseconds,
     * the breaker will trip.
     * @return the length of the measurement window.
     */
     long windowMillis() default -1;

    /**
     * Specifies the number of failures that must occur within a
     * configured time window in order to trip the circuit breaker.
     * @return the number of failures.
     */
    int limit() default -1;


    /**
     * Amount of time in milliseconds after tripping after which the
     * {@link org.fishwife.jrugged.CircuitBreaker} is reset and will
     * allow a test request through.
     * @return the amount of time in milliseconds.
     */
    long resetMillis() default -1;
}
