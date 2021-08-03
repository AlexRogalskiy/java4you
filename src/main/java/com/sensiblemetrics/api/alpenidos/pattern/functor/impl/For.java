package com.sensiblemetrics.api.alpenidos.pattern.functor.impl;

import com.sensiblemetrics.api.alpenidos.pattern.functor.iface.IndexedTask;

public class For {
    public void firstToLimit(final int first, final int limit, final IndexedTask task) {
        for (int i = first; i <= limit; i++) {
            task.execute(i);
        }
    }

    public void firstToLimit(final int limit, final IndexedTask task) {
        for (int i = 0; i <= limit; i++) {
            task.execute(i);
        }
    }
}
