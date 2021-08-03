package com.sensiblemetrics.api.alpenidos.pattern.proxy3.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MultiProxyHandler implements InvocationHandler {

    private static final Logger LOG = LoggerFactory.getLogger(SubjectProxyHandler.class);

    private Object target;

    @SuppressWarnings("rawtypes")
    public MultiProxyHandler(Class clazz) {
        try {
            this.target = clazz.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            LOG.error("Create proxy for {} failed", clazz.getName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        switch (method.getName()) {
            case "hashCode":
                return ((int) method.invoke(target, args)) + 1;
            case "equals":
                return (boolean) method.invoke(target, args);
            case "toString":
                return method.invoke(target, args) + "";
            case "action":
                this.preAction();
                final Object result = method.invoke(target, args);
                this.postAction();
                return result;
            default:
                return method.invoke(target, args);
        }
    }

    private void preAction() {
        LOG.info("SubjectProxyHandler.preAction()");
    }

    private void postAction() {
        LOG.info("SubjectProxyHandler.postAction()");
    }
}
