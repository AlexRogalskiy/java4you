package com.sensiblemetrics.api.alpenidos.pattern.visitor3.factory;

import com.sensiblemetrics.api.alpenidos.pattern.visitor3.impl.Visitor;
import com.sensiblemetrics.api.alpenidos.pattern.visitor3.model.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BuyBasket {
    private final List<Product> list = new ArrayList<>();

    public void accept(final Visitor visitor) {
        final Iterator i = list.iterator();
        while (i.hasNext()) {
            ((Product) i.next()).accept(visitor);
        }
    }

    public void addProduct(final Product product) {
        this.list.add(product);
    }

    public void removeProduct(final Product product) {
        this.list.remove(product);
    }
}
