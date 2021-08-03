package com.sensiblemetrics.api.alpenidos.pattern.stack_machine.exception;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Stack underflow {@link RuntimeException} implementation
 */
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StackUnderflowException extends RuntimeException {

    /**
     * Default explicit serialVersionUID for interoperability
     */
    private static final long serialVersionUID = 8503186355835507208L;

    /**
     * Stack underflow exception constructor with initial input message
     *
     * @param message - initial input message {@link String}
     */
    public StackUnderflowException(final String message) {
        super(message);
    }

    /**
     * Stack underflow exception constructor with initial input {@link Throwable}
     *
     * @param cause - initial input {@link Throwable}
     */
    public StackUnderflowException(final Throwable cause) {
        super(cause);
    }

    /**
     * Stack underflow exception constructor with initial input message and {@link Throwable}
     *
     * @param message - initial input message {@link String}
     * @param cause   - initial input {@link Throwable}
     */
    public StackUnderflowException(final String message, final Throwable cause) {
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
     * Returns {@link StackUnderflowException} by input parameters
     *
     * @param message - initial input message
     * @return {@link StackUnderflowException}
     */
    public static final StackUnderflowException throwError(final String message) {
        throw new StackUnderflowException(message);
    }

    /**
     * Returns {@link StackUnderflowException} by input parameters
     *
     * @param message   - initial input raw message {@link String}
     * @param throwable - initial input cause target {@link Throwable}
     * @return {@link StackUnderflowException}
     */
    public static final StackUnderflowException throwError(final String message, final Throwable throwable) {
        throw new StackUnderflowException(message, throwable);
    }
}
