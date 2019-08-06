package com.sensiblemetrics.api.alpenidos.core.simple_factory;

import com.sensiblemetrics.api.alpenidos.core.simple_factory.factory.TVFactory;
import com.sensiblemetrics.api.alpenidos.core.simple_factory.iface.TV;
import com.sensiblemetrics.api.alpenidos.core.simple_factory.utils.XMLUtilTV;

public class SimpleFactoryPatternLoader {

    public static void main(final String args[]) {
        try {
            final String brandName = XMLUtilTV.getBrandName();
            final TV tv = TVFactory.produceTV(brandName);
            tv.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
