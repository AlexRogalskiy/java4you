package com.sensiblemetrics.api.alpenidos.pattern.scheduler.iface;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * <p>
 * Date: Aug 22, 2011
 *
 * @author moleksyuk
 */
public interface ScheduleOrdering {

    boolean scheduleBefore(final ScheduleOrdering s);
}
