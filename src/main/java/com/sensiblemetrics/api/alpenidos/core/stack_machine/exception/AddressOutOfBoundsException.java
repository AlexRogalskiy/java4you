package com.sensiblemetrics.api.alpenidos.core.stack_machine.exception;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Address out of bounds {@link RuntimeException} implementation
 */
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AddressOutOfBoundsException extends RuntimeException {

    /**
     * Default explicit serialVersionUID for interoperability
     */
    private static final long serialVersionUID = 1199191195202654046L;

    /**
     * Address out of bounds exception constructor with initial input message
     *
     * @param message - initial input message {@link String}
     */
    public AddressOutOfBoundsException(final String message) {
        super(message);
    }

    /**
     * Address out of bounds exception constructor with initial input {@link Throwable}
     *
     * @param cause - initial input {@link Throwable}
     */
    public AddressOutOfBoundsException(final Throwable cause) {
        super(cause);
    }

    /**
     * Address out of bounds exception constructor with initial input message and {@link Throwable}
     *
     * @param message - initial input message {@link String}
     * @param cause   - initial input {@link Throwable}
     */
    public AddressOutOfBoundsException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Returns description message {@link String}
     *
     * @return description message {@link String}
     */
    @Override
    public String getMessage() {
        return super.getMessage();
    }

    /**
     * Returns {@link AddressOutOfBoundsException} by input parameters
     *
     * @param message - initial input message
     * @return {@link AddressOutOfBoundsException}
     */
    public static final AddressOutOfBoundsException throwError(final String message) {
        throw new AddressOutOfBoundsException(message);
    }

    /**
     * Returns {@link AddressOutOfBoundsException} by input parameters
     *
     * @param message   - initial input raw message {@link String}
     * @param throwable - initial input cause target {@link Throwable}
     * @return {@link AddressOutOfBoundsException}
     */
    public static final AddressOutOfBoundsException throwError(final String message, final Throwable throwable) {
        throw new AddressOutOfBoundsException(message, throwable);
    }
}
