package com.sensiblemetrics.api.alpenidos.core.visitor3;

import com.sensiblemetrics.api.alpenidos.core.visitor3.factory.BuyBasket;
import com.sensiblemetrics.api.alpenidos.core.visitor3.impl.Customer;
import com.sensiblemetrics.api.alpenidos.core.visitor3.impl.Saler;
import com.sensiblemetrics.api.alpenidos.core.visitor3.impl.Visitor;
import com.sensiblemetrics.api.alpenidos.core.visitor3.model.Apple;
import com.sensiblemetrics.api.alpenidos.core.visitor3.model.Book;
import com.sensiblemetrics.api.alpenidos.core.visitor3.model.Product;

public class VisitorPatternLoader {

    public static void main(final String a[]) {
        final Product b1 = new Book();
        final Product b2 = new Book();
        final Product a1 = new Apple();

        final Visitor visitor1 = new Saler("saler");
        final Visitor visitor2 = new Customer("customer");

        final BuyBasket basket = new BuyBasket();
        basket.addProduct(b1);
        basket.addProduct(b2);
        basket.addProduct(a1);

        basket.accept(visitor1);
        basket.accept(visitor2);
    }
}
