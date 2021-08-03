package com.sensiblemetrics.api.alpenidos.pattern.dynamic_linkage.impl;

import com.sensiblemetrics.api.alpenidos.pattern.dynamic_linkage.iface.FoodProcessorEnvironmentIF;

import java.net.URL;
import java.net.URLClassLoader;

public class FoodProcessorEnvironment implements FoodProcessorEnvironmentIF {
    private static URL[] classPath;

    static {
        try {
            classPath = new URL[]{new URL("file://bin")};
        } catch (java.net.MalformedURLException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    @Override
    public void slice(final int width) {

    }

    @Override
    public void mix(final int speed) {

    }

    @Override
    public double weight() {
        return 0;
    }

    public void run(final String program) {
        final URLClassLoader classLoader = new URLClassLoader(classPath);
        Class programClass;
        try {
            programClass = classLoader.loadClass(program);
        } catch (ClassNotFoundException e) {
            return;
        }

        AbstractFoodProcessorProgram processorProgram;
        try {
            processorProgram = (AbstractFoodProcessorProgram) programClass.getConstructor().newInstance();
        } catch (Exception e) {
            return;
        }
        processorProgram.setEnvironmentIF(this);
        processorProgram.start();
    }
}
