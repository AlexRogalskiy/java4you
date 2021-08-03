package com.sensiblemetrics.api.alpenidos.pattern.filter.factory;

import com.sensiblemetrics.api.alpenidos.pattern.filter.iface.Filter;
import com.sensiblemetrics.api.alpenidos.pattern.filter.model.Order;

/**
 * Filter Chain carries multiple filters and help to execute them in defined order on target.
 *
 * @author joshzambales
 */
public class FilterChain {
    private Filter chain;

    /**
     * Adds filter
     */
    public void addFilter(final Filter filter) {
        if (this.chain == null) {
            this.chain = filter;
        } else {
            this.chain.getLast().setNext(filter);
        }
    }

    /**
     * Execute filter chain
     */
    public String execute(final Order order) {
        if (this.chain != null) {
            return this.chain.execute(order);
        }
        return "RUNNING...";
    }
}
