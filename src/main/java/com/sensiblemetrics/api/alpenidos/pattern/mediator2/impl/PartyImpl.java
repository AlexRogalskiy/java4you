package com.sensiblemetrics.api.alpenidos.pattern.mediator2.impl;

import com.sensiblemetrics.api.alpenidos.pattern.mediator2.enums.Action;
import com.sensiblemetrics.api.alpenidos.pattern.mediator2.iface.Party;
import com.sensiblemetrics.api.alpenidos.pattern.mediator2.iface.PartyMember;

import java.util.ArrayList;
import java.util.List;

/**
 * Party implementation.
 */
public class PartyImpl implements Party {
    private final List<PartyMember> members;

    public PartyImpl() {
        this.members = new ArrayList<>();
    }

    @Override
    public void act(final PartyMember actor, final Action action) {
        this.members.stream().filter(m -> !m.equals(actor)).forEach(m -> m.partyAction(action));
    }

    @Override
    public void addMember(final PartyMember member) {
        this.members.add(member);
        member.joinedParty(this);
    }
}
