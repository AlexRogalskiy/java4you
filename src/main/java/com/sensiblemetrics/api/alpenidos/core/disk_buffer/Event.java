package com.sensiblemetrics.api.alpenidos.core.disk_buffer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class Event {
    public enum ID {
        Alias,
        DocumentEnd,
        DocumentStart,
        MappingEnd,
        MappingStart,
        Scalar,
        SequenceEnd,
        SequenceStart,
        StreamEnd,
        StreamStart
    }

    private final String id;
    private final ID startMark;
    private final ID endMark;

    public abstract boolean is(final Event.ID id);
}
