package com.sensiblemetrics.api.alpenidos.core.databus.model;

import com.sensiblemetrics.api.alpenidos.core.databus.iface.DataType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * An event raised when a string message is sent.
 *
 * @author Paul Campbell (pcampbell@kemitix.net)
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@RequiredArgsConstructor
public class MessageData extends AbstractDataType {
    private final String message;

    public static DataType of(final String message) {
        return new MessageData(message);
    }
}
