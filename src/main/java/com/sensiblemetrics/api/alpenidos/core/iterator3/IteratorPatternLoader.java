package com.sensiblemetrics.api.alpenidos.core.iterator3;

import com.sensiblemetrics.api.alpenidos.core.iterator3.iface.MyCollection;
import com.sensiblemetrics.api.alpenidos.core.iterator3.iface.MyIterator;
import com.sensiblemetrics.api.alpenidos.core.iterator3.model.NewCollection;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IteratorPatternLoader {

    public static void process(final MyCollection collection) {
        final MyIterator i = collection.createIterator();
        while (!i.isLast()) {
            log.info(i.currentItem().toString());
            i.next();
        }
    }

    public static void main(final String a[]) {
        final MyCollection collection = new NewCollection();
        process(collection);
    }
}
