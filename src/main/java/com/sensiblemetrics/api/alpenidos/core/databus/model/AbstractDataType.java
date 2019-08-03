package com.sensiblemetrics.api.alpenidos.core.databus.model;

import com.sensiblemetrics.api.alpenidos.core.databus.iface.DataType;
import com.sensiblemetrics.api.alpenidos.core.databus.impl.DataBus;
import lombok.Data;

/**
 * Base for data to send via the Data-Bus.
 *
 * @author Paul Campbell (pcampbell@kemitix.net)
 */
@Data
public class AbstractDataType implements DataType {
    private DataBus dataBus;
}
