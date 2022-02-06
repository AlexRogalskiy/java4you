package com.sensiblemetrics.api.alpenidos.pattern.price.factory;

import com.sensiblemetrics.api.alpenidos.pattern.price.enumeration.OldStylePlan;
import com.sensiblemetrics.api.alpenidos.pattern.price.impl.BasicDeliveryPriceCalculator;
import com.sensiblemetrics.api.alpenidos.pattern.price.impl.BusinessDeliveryPriceCalculator;
import com.sensiblemetrics.api.alpenidos.pattern.price.impl.PremiumDeliveryPriceCalculator;
import com.sensiblemetrics.api.alpenidos.pattern.price.interfaces.DeliveryPriceCalculator;

public class PriceCalculatorFactory {

    public DeliveryPriceCalculator priceCalculatorFor(final OldStylePlan plan) {
        if (plan.equals(OldStylePlan.BASIC)) {
            return new BasicDeliveryPriceCalculator();
        } else if (plan.equals(OldStylePlan.PREMIUM)) {
            return new PremiumDeliveryPriceCalculator();
        } else if (plan.equals(OldStylePlan.BUSINESS)) {
            return new BusinessDeliveryPriceCalculator();
        }

        throw new IllegalArgumentException("No support for plan " + plan);
    }
}
