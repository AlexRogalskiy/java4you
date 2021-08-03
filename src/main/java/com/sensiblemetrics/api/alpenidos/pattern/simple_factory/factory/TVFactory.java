package com.sensiblemetrics.api.alpenidos.pattern.simple_factory.factory;

import com.sensiblemetrics.api.alpenidos.pattern.simple_factory.iface.TV;
import com.sensiblemetrics.api.alpenidos.pattern.simple_factory.impl.HaierTV;
import com.sensiblemetrics.api.alpenidos.pattern.simple_factory.impl.HisenseTV;

public class TVFactory {

    public static TV produceTV(final String brand) throws Exception {
        if (brand.equalsIgnoreCase("Haier")) {
            return new HaierTV();
        } else if (brand.equalsIgnoreCase("Hisense")) {
            return new HisenseTV();
        }
        throw new Exception("Unsupported TV brand " + brand);
    }
}
