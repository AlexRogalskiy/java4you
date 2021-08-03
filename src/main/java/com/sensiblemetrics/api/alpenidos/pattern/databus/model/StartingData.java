package com.sensiblemetrics.api.alpenidos.pattern.databus.model;

import com.sensiblemetrics.api.alpenidos.pattern.databus.iface.DataType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * An event raised when applications starts, containing the start time of the application.
 *
 * @author Paul Campbell (pcampbell@kemitix.net)
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@RequiredArgsConstructor
public class StartingData extends AbstractDataType {
    private final LocalDateTime when;

    public static DataType of(final LocalDateTime when) {
        return new StartingData(when);
    }
}
