package com.sensiblemetrics.api.alpenidos.core.filter.impl;

import com.sensiblemetrics.api.alpenidos.core.filter.model.Order;
import com.sensiblemetrics.api.alpenidos.core.filter.iface.Filter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

import static org.apache.commons.lang3.StringUtils.EMPTY;

/**
 * Base class for order processing filters. Handles chain management.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractFilter implements Filter {
    private Filter next;

    @Override
    public Filter getLast() {
        Filter last = this;
        while (last.getNext() != null) {
            last = last.getNext();
        }
        return last;
    }

    @Override
    public String execute(final Order order) {
        return Optional.ofNullable(this.getNext()).map(n -> n.execute(order)).orElse(EMPTY);
    }
}
