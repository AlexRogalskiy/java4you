package com.sensiblemetrics.api.alpenidos.pattern.databus.member;

import com.sensiblemetrics.api.alpenidos.pattern.databus.iface.DataType;
import com.sensiblemetrics.api.alpenidos.pattern.databus.iface.Member;
import com.sensiblemetrics.api.alpenidos.pattern.databus.model.MessageData;
import com.sensiblemetrics.api.alpenidos.pattern.databus.model.StartingData;
import com.sensiblemetrics.api.alpenidos.pattern.databus.model.StoppingData;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

/**
 * Receiver of Data-Bus events.
 *
 * @author Paul Campbell (pcampbell@kemitix.net)
 */
@Getter
@Slf4j
@RequiredArgsConstructor
public class StatusMember implements Member {

    private final int id;

    private LocalDateTime started;
    private LocalDateTime stopped;

    @Override
    public void accept(final DataType data) {
        if (data instanceof StartingData) {
            this.handleEvent((StartingData) data);
        } else if (data instanceof StoppingData) {
            this.handleEvent((StoppingData) data);
        }
    }

    private void handleEvent(final StartingData data) {
        this.started = data.getWhen();
        log.info(String.format("Receiver #%d sees application started at %s", id, started));
    }

    private void handleEvent(StoppingData data) {
        this.stopped = data.getWhen();
        log.info(String.format("Receiver #%d sees application stopping at %s", id, stopped));
        log.info(String.format("Receiver #%d sending goodbye message", id));
        data.getDataBus().publish(MessageData.of(String.format("Goodbye cruel world from #%d!", id)));
    }
}
