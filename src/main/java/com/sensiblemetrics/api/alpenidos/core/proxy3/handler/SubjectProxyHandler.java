package com.sensiblemetrics.api.alpenidos.core.proxy3.handler;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class SubjectProxyHandler implements InvocationHandler {
    private Object target;

    @SuppressWarnings("rawtypes")
    public SubjectProxyHandler(final Class clazz) {
        try {
            this.target = clazz.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            log.error("Create proxy for {} failed", clazz.getName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
        this.preAction();
        final Object result = method.invoke(target, args);
        this.postAction();
        return result;
    }

    private void preAction() {
        log.info("SubjectProxyHandler.preAction()");
    }

    private void postAction() {
        log.info("SubjectProxyHandler.postAction()");
    }
}
