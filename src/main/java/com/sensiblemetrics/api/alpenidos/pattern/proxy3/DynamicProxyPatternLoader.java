package com.sensiblemetrics.api.alpenidos.pattern.proxy3;

import com.sensiblemetrics.api.alpenidos.pattern.proxy3.handler.SubjectProxyHandler;
import com.sensiblemetrics.api.alpenidos.pattern.proxy3.iface.ISubject;
import com.sensiblemetrics.api.alpenidos.pattern.proxy3.impl.ConcreteSubject;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

@Slf4j
public class DynamicProxyPatternLoader {
    private static int creation = 100000000;
    private static int execution = 1000000000;

    public static void main(String[] args) {
        testJDKDynamicCreation();
        testJDKDynamicExecution();
    }

    private static void testJDKDynamicCreation() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < creation; i++) {
            final InvocationHandler handler = new SubjectProxyHandler(ConcreteSubject.class);
            Proxy.newProxyInstance(DynamicProxyPatternLoader.class.getClassLoader(), new Class[]{ISubject.class}, handler);
        }
        long stop = System.currentTimeMillis();
        log.info("JDK creation time : {} ms", stop - start);
    }

    private static void testJDKDynamicExecution() {
        final long start = System.currentTimeMillis();
        final InvocationHandler handler = new SubjectProxyHandler(ConcreteSubject.class);
        final ISubject subject = (ISubject) Proxy.newProxyInstance(DynamicProxyPatternLoader.class.getClassLoader(), new Class[]{ISubject.class}, handler);
        for (int i = 0; i < execution; i++) {
            subject.action();
        }
        long stop = System.currentTimeMillis();
        log.info("JDK execution time : {} ms", stop - start);
    }
}
