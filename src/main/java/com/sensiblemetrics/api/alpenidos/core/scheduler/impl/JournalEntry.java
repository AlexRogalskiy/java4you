package com.sensiblemetrics.api.alpenidos.core.scheduler.impl;

import com.sensiblemetrics.api.alpenidos.core.scheduler.iface.ScheduleOrdering;

import java.util.Date;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * <p>
 * Date: Aug 22, 2011
 *
 * @author moleksyuk
 */
public class JournalEntry implements ScheduleOrdering {
    private Date time = new Date();

    public Date getTime() {
        return this.time;
    }

    /*
     * (non-Javadoc)
     *
     */
    @Override
    public boolean scheduleBefore(final ScheduleOrdering s) {
        if (s instanceof JournalEntry) {
            return getTime().before(((JournalEntry) s).getTime());
        }
        return false;
    }
}
