package com.sensiblemetrics.api.alpenidos.pattern.mediator2.impl;

import com.sensiblemetrics.api.alpenidos.pattern.mediator2.enums.Action;
import com.sensiblemetrics.api.alpenidos.pattern.mediator2.iface.Party;
import com.sensiblemetrics.api.alpenidos.pattern.mediator2.iface.PartyMember;
import lombok.extern.slf4j.Slf4j;

/**
 * Abstract base class for party members.
 */
@Slf4j
public abstract class PartyMemberBase implements PartyMember {

    protected Party party;

    @Override
    public void joinedParty(final Party party) {
        log.info("{} joins the party", this);
        this.party = party;
    }

    @Override
    public void partyAction(final Action action) {
        log.info("{} {}", this, action.getDescription());
    }

    @Override
    public void act(final Action action) {
        if (this.party != null) {
            log.info("{} {}", this, action);
            this.party.act(this, action);
        }
    }

    @Override
    public abstract String toString();
}
