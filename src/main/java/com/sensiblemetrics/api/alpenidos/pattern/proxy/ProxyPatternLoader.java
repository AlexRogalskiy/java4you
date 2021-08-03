package com.sensiblemetrics.api.alpenidos.pattern.proxy;

import com.sensiblemetrics.api.alpenidos.pattern.proxy.iface.ExpensiveObject;
import com.sensiblemetrics.api.alpenidos.pattern.proxy.impl.ExpensiveObjectProxy;

public class ProxyPatternLoader {
    public static void main(String[] args) {
        final ExpensiveObject object = new ExpensiveObjectProxy();
        object.process();
        object.process();
    }
}
