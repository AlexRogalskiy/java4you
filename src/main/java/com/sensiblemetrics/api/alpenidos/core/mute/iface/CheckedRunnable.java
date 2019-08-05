package com.sensiblemetrics.api.alpenidos.core.mute.iface;

/**
 * A runnable which may throw exception on execution.
 */
@FunctionalInterface
public interface CheckedRunnable {
    /**
     * Same as {@link Runnable#run()} with a possibility of exception in execution.
     *
     * @throws Exception if any exception occurs.
     */
    void run() throws Exception;
}
