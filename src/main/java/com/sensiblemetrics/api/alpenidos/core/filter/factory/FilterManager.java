package com.sensiblemetrics.api.alpenidos.core.filter.factory;

import com.sensiblemetrics.api.alpenidos.core.filter.iface.Filter;
import com.sensiblemetrics.api.alpenidos.core.filter.model.Order;
import lombok.Data;

/**
 * Filter Manager manages the filters and {@link FilterChain}.
 *
 * @author joshzambales
 */
@Data
public class FilterManager {
    private final FilterChain filterChain;

    public FilterManager() {
        this.filterChain = new FilterChain();
    }

    public void addFilter(final Filter filter) {
        this.filterChain.addFilter(filter);
    }

    public String filterRequest(final Order order) {
        return this.filterChain.execute(order);
    }
}
