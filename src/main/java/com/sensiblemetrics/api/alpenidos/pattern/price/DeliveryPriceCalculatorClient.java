package com.sensiblemetrics.api.alpenidos.pattern.price;

import com.sensiblemetrics.api.alpenidos.pattern.price.enumeration.OldStylePlan;
import com.sensiblemetrics.api.alpenidos.pattern.price.enumeration.Plan;
import com.sensiblemetrics.api.alpenidos.pattern.price.factory.PriceCalculatorFactory;
import com.sensiblemetrics.api.alpenidos.pattern.price.interfaces.DeliveryPriceCalculator;
import com.sensiblemetrics.api.alpenidos.pattern.price.model.Item;

import java.math.BigDecimal;

public class DeliveryPriceCalculatorClient {

    public static void main(final String[] args) {
        final PriceCalculatorFactory factory = new PriceCalculatorFactory();

        // Old style
        final Item newItem = new Item(1L, new BigDecimal("12.99"));
        final DeliveryPriceCalculator priceCalculator = factory.priceCalculatorFor(OldStylePlan.BASIC);
        System.out.println("Delivery price is " + priceCalculator.priceFor(newItem));

        //Functional style
        final Item item = new Item(1L, new BigDecimal("12.99"));
        System.out.println("Delivery price is " + Plan.BASIC.deliveryPrice.apply(item));
        System.out.println("Delivery price is " + Plan.PREMIUM.deliveryPrice.apply(item));
        System.out.println("Delivery price is " + Plan.BUSINESS.deliveryPrice.apply(item));
    }
}
