package com.sensiblemetrics.api.alpenidos.core.trampoline;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>Trampoline pattern allows to define recursive algorithms by iterative loop </p>
 * <p>it is possible to implement algorithms recursively in Java without blowing the stack
 * and to interleave the execution of functions without hard coding them together or even using threads.</p>
 */
@Slf4j
public class TrampolinePatternLoader {

    /**
     * Main program for showing pattern. It does loop with factorial function.
     */
    public static void main(final String[] args) {
        log.info("start pattern");
        final Integer result = loop(10, 1).result();
        log.info("result {}", result);

    }

    /**
     * Manager for pattern. Define it with a factorial function.
     */
    public static Trampoline<Integer> loop(final int times, final int prod) {
        if (times == 0) {
            return Trampoline.done(prod);
        }
        return Trampoline.more(() -> loop(times - 1, prod * times));
    }
}
