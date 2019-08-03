package com.sensiblemetrics.api.alpenidos.core.databus.member;

import com.sensiblemetrics.api.alpenidos.core.databus.iface.DataType;
import com.sensiblemetrics.api.alpenidos.core.databus.iface.Member;
import com.sensiblemetrics.api.alpenidos.core.databus.model.MessageData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Receiver of Data-Bus events that collects the messages from each {@link MessageData}.
 *
 * @author Paul Campbell (pcampbell@kemitix.net)
 */
@Slf4j
@RequiredArgsConstructor
public class MessageCollectorMember implements Member {
    private final String name;
    private final List<String> messages = new ArrayList<>();

    @Override
    public void accept(final DataType data) {
        if (data instanceof MessageData) {
            this.handleEvent((MessageData) data);
        }
    }

    private void handleEvent(final MessageData data) {
        log.info(String.format("%s sees message %s", name, data.getMessage()));
        this.messages.add(data.getMessage());
    }

    public List<String> getMessages() {
        return Collections.unmodifiableList(this.messages);
    }
}
