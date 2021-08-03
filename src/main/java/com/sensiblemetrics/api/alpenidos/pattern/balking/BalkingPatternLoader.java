package com.sensiblemetrics.api.alpenidos.pattern.balking;

import com.sensiblemetrics.api.alpenidos.pattern.balking.iface.WashingMachineIF;
import com.sensiblemetrics.api.alpenidos.pattern.balking.impl.WashingMachine;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * In Balking Design Pattern if an object’s method is invoked when it is in an inappropriate state,
 * then the method will return without doing anything. Objects that use this pattern are generally only in a
 * state that is prone to balking temporarily but for an unknown amount of time
 * <p>
 * In this example implementation WashingMachine is an object that has two states
 * in which it can be: ENABLED and WASHING. If the machine is ENABLED
 * the state is changed into WASHING that any other thread can't invoke this action on this and then do the job.
 * On the other hand if it have been already washing and any other thread execute wash()
 * it can't do that once again and returns doing nothing.
 */
@Slf4j
public class BalkingPatternLoader {

    /**
     * @param args the command line arguments - not used
     */
    public static void main(final String... args) {
        final WashingMachineIF washingMachine = new WashingMachine();
        final ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executorService.execute(washingMachine::wash);
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException ie) {
            log.error("ERROR: Waiting on executor service shutdown!");
        }
    }
}
