package com.sensiblemetrics.api.alpenidos.core.mediator2.iface;

import com.sensiblemetrics.api.alpenidos.core.mediator2.enums.Action;

/**
 * Party interface.
 */
public interface Party {

    void addMember(final PartyMember member);

    void act(final PartyMember actor, final Action action);
}
