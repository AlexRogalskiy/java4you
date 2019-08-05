package com.sensiblemetrics.api.alpenidos.core.servant;

import com.sensiblemetrics.api.alpenidos.core.servant.iface.Royalty;
import com.sensiblemetrics.api.alpenidos.core.servant.impl.King;
import com.sensiblemetrics.api.alpenidos.core.servant.impl.Queen;
import com.sensiblemetrics.api.alpenidos.core.servant.impl.Servant;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;


/**
 * Servant offers some functionality to a group of classes without defining that functionality in
 * each of them. A Servant is a class whose instance provides methods that take care of a desired
 * service, while objects for which the servant does something, are taken as parameters.
 * <p>
 * In this example {@link Servant} is serving {@link King} and {@link Queen}.
 */
@Slf4j
public class ServantPatternLoader {
    private static Servant jenkins = new Servant("Jenkins");
    private static Servant travis = new Servant("Travis");

    /**
     * Program entry point
     */
    public static void main(final String[] args) {
        scenario(jenkins, 1);
        scenario(travis, 0);
    }

    /**
     * Can add a List with enum Actions for variable scenarios
     */
    public static void scenario(final Servant servant, int compliment) {
        final King k = new King();
        final Queen q = new Queen();

        final List<Royalty> guests = new ArrayList<>();
        guests.add(k);
        guests.add(q);

        // feed
        servant.feed(k);
        servant.feed(q);
        // serve drinks
        servant.giveWine(k);
        servant.giveWine(q);
        // compliment
        servant.giveCompliments(guests.get(compliment));

        guests.forEach(Royalty::changeMood);

        // check your luck
        if (servant.checkIfYouWillBeHanged(guests)) {
            log.info("{} will live another day", servant.name);
        } else {
            log.info("Poor {}. His days are numbered", servant.name);
        }
    }
}
