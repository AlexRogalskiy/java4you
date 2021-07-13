package com.sensiblemetrics.api.alpenidos.core.singleton3;

public class StaticSingleton {

    private static final StaticSingleton INSTANCE;

    static {
        INSTANCE = new StaticSingleton();
    }

    private StaticSingleton() {
    }

    ;

    public static StaticSingleton getInstance() {
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        StaticSingleton m1 = StaticSingleton.getInstance();
        StaticSingleton m2 = StaticSingleton.getInstance();
        System.out.println(m1 == m2);
    }
}
