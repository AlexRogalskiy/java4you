package com.sensiblemetrics.api.alpenidos.pattern.databus.iface;

import com.sensiblemetrics.api.alpenidos.pattern.databus.impl.DataBus;

/**
 * Events are sent via the Data-Bus.
 *
 * @author Paul Campbell (pcampbell@kemitix.net)
 */

public interface DataType {

    /**
     * Returns the data-bus the event is being sent on.
     *
     * @return The data-bus
     */
    DataBus getDataBus();

    /**
     * Set the data-bus the event will be sent on.
     *
     * @param dataBus The data-bus
     */
    void setDataBus(final DataBus dataBus);
}
