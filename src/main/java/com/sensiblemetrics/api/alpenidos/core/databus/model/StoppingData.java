package com.sensiblemetrics.api.alpenidos.core.databus.model;

import com.sensiblemetrics.api.alpenidos.core.databus.iface.DataType;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

/**
 * An event raised when applications stops, containing the stop time of the application.
 *
 * @author Paul Campbell (pcampbell@kemitix.net)
 */
@Data
@RequiredArgsConstructor
public class StoppingData extends AbstractDataType {
    private final LocalDateTime when;

    public static DataType of(final LocalDateTime when) {
        return new StoppingData(when);
    }
}
