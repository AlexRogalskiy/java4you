package com.sensiblemetrics.api.alpenidos.core.native_memory;

import java.lang.reflect.Constructor;
import lombok.experimental.UtilityClass;
import sun.misc.Unsafe;

@UtilityClass
public class UnsafeUtils {

    public static Unsafe createUnsafe() {
        try {
            Constructor<Unsafe> unsafeConstructor = Unsafe.class.getDeclaredConstructor();
            unsafeConstructor.setAccessible(true);
            return unsafeConstructor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
