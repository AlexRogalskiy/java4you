package com.sensiblemetrics.api.alpenidos.pattern.mute.impl;

import com.sensiblemetrics.api.alpenidos.pattern.mute.iface.CheckedRunnable;
import lombok.experimental.UtilityClass;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * A utility class that allows you to utilize mute idiom.
 */
@UtilityClass
public final class Mute {

    /**
     * Executes the <code>runnable</code> and throws the exception occurred within a {@link AssertionError}.
     * This method should be utilized to mute the operations that are guaranteed not to throw an exception.
     * For instance {@link ByteArrayOutputStream#write(byte[])} declares in it's signature that it can throw
     * an {@link IOException}, but in reality it cannot. This is because the bulk write method is not overridden
     * in {@link ByteArrayOutputStream}.
     *
     * @param runnable a runnable that should never throw an exception on execution.
     */
    public static void mute(final CheckedRunnable runnable) {
        try {
            runnable.run();
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    /**
     * Executes the <code>runnable</code> and logs the exception occurred on {@link System#err}.
     * This method should be utilized to mute the operations about which most you can do is log.
     * For instance while closing a connection to database, or cleaning up a resource,
     * all you can do is log the exception occurred.
     *
     * @param runnable a runnable that may throw an exception on execution.
     */
    public static void loggedMute(final CheckedRunnable runnable) {
        try {
            runnable.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
