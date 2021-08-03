package com.sensiblemetrics.api.alpenidos.pattern.decorator3;

import com.sensiblemetrics.api.alpenidos.pattern.decorator3.impl.NewlyRegisteredDiscount;
import com.sensiblemetrics.api.alpenidos.pattern.decorator3.impl.ReferencedUserDiscount;
import com.sensiblemetrics.api.alpenidos.pattern.decorator3.impl.TwoYearPlanDiscount;
import java.math.BigDecimal;

public class DecoratorScenario {

    public static void main(final String args[]) {
        final NewlyRegisteredDiscount newlyRegisteredDiscount = new NewlyRegisteredDiscount();
        final ReferencedUserDiscount referencedUserDiscount = new ReferencedUserDiscount(newlyRegisteredDiscount);
        final TwoYearPlanDiscount twoYearPlanDiscount = new TwoYearPlanDiscount(referencedUserDiscount);
        final BigDecimal discountPrice = twoYearPlanDiscount.apply(new BigDecimal(100));
    }
}
