package com.sensiblemetrics.api.alpenidos.core.mediator2.iface;

import com.sensiblemetrics.api.alpenidos.core.mediator2.enums.Action;

/**
 * Interface for party members interacting with {@link Party}.
 */
public interface PartyMember {

    void joinedParty(final Party party);

    void partyAction(final Action action);

    void act(final Action action);
}
