package com.sensiblemetrics.api.alpenidos.pattern.adapter9;

import com.sensiblemetrics.api.alpenidos.pattern.adapter9.management.SquarePegAdapter;
import com.sensiblemetrics.api.alpenidos.pattern.adapter9.round.RoundHole;
import com.sensiblemetrics.api.alpenidos.pattern.adapter9.round.RoundPeg;
import com.sensiblemetrics.api.alpenidos.pattern.adapter9.square.SquarePeg;

/**
 * EN: Somewhere in client code...
 * <p>
 * RU: Где-то в клиентском коде...
 */
public class Demo {

    public static void main(String[] args) {
        final RoundHole hole = new RoundHole(5);

        final RoundPeg rpeg = new RoundPeg(5);
        if (hole.fits(rpeg)) {
            System.out.println("Round peg r5 fits round hole r5.");
        }

        final SquarePeg smallSqPeg = new SquarePeg(2);
        final SquarePeg largeSqPeg = new SquarePeg(20);

        final SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
        final SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);
        if (hole.fits(smallSqPegAdapter)) {
            System.out.println("Square peg w2 fits round hole r5.");
        }
        if (!hole.fits(largeSqPegAdapter)) {
            System.out.println("Square peg w20 does not fit into round hole r5.");
        }
    }
}
