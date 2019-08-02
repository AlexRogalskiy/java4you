package com.sensiblemetrics.api.alpenidos.core.proxy;

import com.sensiblemetrics.api.alpenidos.core.proxy.iface.ExpensiveObject;
import com.sensiblemetrics.api.alpenidos.core.proxy.impl.ExpensiveObjectProxy;

public class ProxyPatternLoader {
    public static void main(String[] args) {
        final ExpensiveObject object = new ExpensiveObjectProxy();
        object.process();
        object.process();
    }
}
