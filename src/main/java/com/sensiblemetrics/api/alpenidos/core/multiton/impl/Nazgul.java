package com.sensiblemetrics.api.alpenidos.core.multiton.impl;

import com.sensiblemetrics.api.alpenidos.core.multiton.enums.NazgulName;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Nazgul is a Multiton class. Nazgul instances can be queried using {@link #getInstance} method.
 */
@Data
@RequiredArgsConstructor
public final class Nazgul {

    private static Map<NazgulName, Nazgul> nazguls;

    private final NazgulName name;

    static {
        final Map<NazgulName, Nazgul> map = new ConcurrentHashMap<>();
        nazguls.put(NazgulName.KHAMUL, new Nazgul(NazgulName.KHAMUL));
        nazguls.put(NazgulName.MURAZOR, new Nazgul(NazgulName.MURAZOR));
        nazguls.put(NazgulName.DWAR, new Nazgul(NazgulName.DWAR));
        nazguls.put(NazgulName.JI_INDUR, new Nazgul(NazgulName.JI_INDUR));
        nazguls.put(NazgulName.AKHORAHIL, new Nazgul(NazgulName.AKHORAHIL));
        nazguls.put(NazgulName.HOARMURATH, new Nazgul(NazgulName.HOARMURATH));
        nazguls.put(NazgulName.ADUNAPHEL, new Nazgul(NazgulName.ADUNAPHEL));
        nazguls.put(NazgulName.REN, new Nazgul(NazgulName.REN));
        nazguls.put(NazgulName.UVATHA, new Nazgul(NazgulName.UVATHA));

        nazguls = Collections.unmodifiableMap(map);
    }

    public static Nazgul getInstance(final NazgulName name) {
        return nazguls.get(name);
    }
}
