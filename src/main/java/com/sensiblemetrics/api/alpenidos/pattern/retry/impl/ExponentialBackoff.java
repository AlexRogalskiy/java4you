package com.sensiblemetrics.api.alpenidos.pattern.retry.impl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExponentialBackoff {

    public interface Job {
        boolean run() throws Exception;
    }

    public static void retryAfter(final long initialDelay, final long maxDelay, final double factor, final String jobDescription, final Job job)
        throws InterruptedException {
        long delay = initialDelay;

        while (true) {
            Exception f = null;
            try {
                if (job.run())
                    break;
            } catch (InterruptedException e) {
                throw e;
            } catch (Exception e) {
                f = e;
            }
            if (f != null)
                log.error(jobDescription + " failed. Retrying in " + (delay / 1000) + "s.", f);
            else
                log.info(jobDescription + " failed. Retrying in " + (delay / 1000) + "s.");
            Thread.sleep(delay);
            delay = Math.min(maxDelay, (long) (delay * factor));
        }
        log.debug(jobDescription + " succeeded.");
    }
}
