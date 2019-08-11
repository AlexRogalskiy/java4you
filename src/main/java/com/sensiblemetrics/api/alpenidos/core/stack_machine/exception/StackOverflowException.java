package com.sensiblemetrics.api.alpenidos.core.stack_machine.exception;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Stack overflow {@link RuntimeException} implementation
 */
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StackOverflowException extends RuntimeException {

    /**
     * Default explicit serialVersionUID for interoperability
     */
    private static final long serialVersionUID = 3021347509104618868L;

    /**
     * Stack overflow exception constructor with initial input message
     *
     * @param message - initial input message {@link String}
     */
    public StackOverflowException(final String message) {
        super(message);
    }

    /**
     * Stack overflow exception constructor with initial input {@link Throwable}
     *
     * @param cause - initial input {@link Throwable}
     */
    public StackOverflowException(final Throwable cause) {
        super(cause);
    }

    /**
     * Stack overflow exception constructor with initial input message and {@link Throwable}
     *
     * @param message - initial input message {@link String}
     * @param cause   - initial input {@link Throwable}
     */
    public StackOverflowException(final String message, final Throwable cause) {
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
     * Returns {@link StackOverflowException} by input parameters
     *
     * @param message - initial input message
     * @return {@link StackOverflowException}
     */
    public static final StackOverflowException throwError(final String message) {
        throw new StackOverflowException(message);
    }

    /**
     * Returns {@link StackOverflowException} by input parameters
     *
     * @param message   - initial input raw message {@link String}
     * @param throwable - initial input cause target {@link Throwable}
     * @return {@link StackOverflowException}
     */
    public static final StackOverflowException throwError(final String message, final Throwable throwable) {
        throw new StackOverflowException(message, throwable);
    }
}
