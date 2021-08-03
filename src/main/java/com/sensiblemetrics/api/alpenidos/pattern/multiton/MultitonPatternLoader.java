package com.sensiblemetrics.api.alpenidos.pattern.multiton;

import com.sensiblemetrics.api.alpenidos.pattern.multiton.enums.NazgulEnum;
import com.sensiblemetrics.api.alpenidos.pattern.multiton.enums.NazgulName;
import com.sensiblemetrics.api.alpenidos.pattern.multiton.impl.Nazgul;
import lombok.extern.slf4j.Slf4j;

/**
 * Whereas Singleton design pattern introduces single globally accessible object the Multiton pattern defines many globally accessible objects. The client asks
 * for the correct instance from the Multiton by passing an enumeration as parameter.
 * <p>
 * There is more than one way to implement the multiton design pattern. In the first example {@link Nazgul} is the Multiton and we can ask single {@link Nazgul}
 * from it using {@link NazgulName}. The {@link Nazgul}s are statically initialized and stored in concurrent hash map.
 * <p>
 * In the enum implementation {@link NazgulEnum} is the multiton. It is static and mutable because of the way java supports enums.
 */
@Slf4j
public class MultitonPatternLoader {

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        // eagerly initialized multiton
        log.info("KHAMUL={}", Nazgul.getInstance(NazgulName.KHAMUL));
        log.info("MURAZOR={}", Nazgul.getInstance(NazgulName.MURAZOR));
        log.info("DWAR={}", Nazgul.getInstance(NazgulName.DWAR));
        log.info("JI_INDUR={}", Nazgul.getInstance(NazgulName.JI_INDUR));
        log.info("AKHORAHIL={}", Nazgul.getInstance(NazgulName.AKHORAHIL));
        log.info("HOARMURATH={}", Nazgul.getInstance(NazgulName.HOARMURATH));
        log.info("ADUNAPHEL={}", Nazgul.getInstance(NazgulName.ADUNAPHEL));
        log.info("REN={}", Nazgul.getInstance(NazgulName.REN));
        log.info("UVATHA={}", Nazgul.getInstance(NazgulName.UVATHA));

        // enum multiton
        log.info("KHAMUL={}", NazgulEnum.KHAMUL);
        log.info("MURAZOR={}", NazgulEnum.MURAZOR);
        log.info("DWAR={}", NazgulEnum.DWAR);
        log.info("JI_INDUR={}", NazgulEnum.JI_INDUR);
        log.info("AKHORAHIL={}", NazgulEnum.AKHORAHIL);
        log.info("HOARMURATH={}", NazgulEnum.HOARMURATH);
        log.info("ADUNAPHEL={}", NazgulEnum.ADUNAPHEL);
        log.info("REN={}", NazgulEnum.REN);
        log.info("UVATHA={}", NazgulEnum.UVATHA);
    }
}
