package com.sensiblemetrics.api.alpenidos.pattern.callback;

import com.sensiblemetrics.api.alpenidos.pattern.callback.iface.Callback;
import com.sensiblemetrics.api.alpenidos.pattern.callback.model.SimpleTask;
import com.sensiblemetrics.api.alpenidos.pattern.callback.model.Task;
import lombok.extern.slf4j.Slf4j;

/**
 * Callback pattern is more native for functional languages where functions are treated as
 * first-class citizens. Prior to Java 8 callbacks can be simulated using simple (alike command)
 * interfaces.
 */
@Slf4j
public class CallbackPatternLoader {

    /**
     * Program entry point
     */
    public static void main(final String[] args) {
        final Task task = new SimpleTask();
        final Callback callback = () -> log.info("I'm done now.");
        task.executeWith(callback);
    }
}
