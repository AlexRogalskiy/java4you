package com.sensiblemetrics.api.alpenidos.core.databus.iface;

import com.sensiblemetrics.api.alpenidos.core.databus.iface.DataType;

import java.util.function.Consumer;

/**
 * Members receive events from the Data-Bus.
 *
 * @author Paul Campbell (pcampbell@kemitix.net)
 */
public interface Member extends Consumer<DataType> {

    void accept(final DataType event);
}
