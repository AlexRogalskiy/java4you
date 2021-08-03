package com.sensiblemetrics.api.alpenidos.pattern.servant.impl;

import com.sensiblemetrics.api.alpenidos.pattern.servant.iface.Royalty;
import java.util.List;
import lombok.RequiredArgsConstructor;

/**
 * Servant
 */
@RequiredArgsConstructor
public class Servant {

    public final String name;

    public void feed(final Royalty r) {
        r.getFed();
    }

    public void giveWine(final Royalty r) {
        r.getDrink();
    }

    public void giveCompliments(final Royalty r) {
        r.receiveCompliments();
    }

    /**
     * Check if we will be hanged
     */
    public boolean checkIfYouWillBeHanged(final List<Royalty> tableGuests) {
        boolean anotherDay = true;
        for (final Royalty r : tableGuests) {
            if (!r.getMood()) {
                anotherDay = false;
            }
        }
        return anotherDay;
    }
}
