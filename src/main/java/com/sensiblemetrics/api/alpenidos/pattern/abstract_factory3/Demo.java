package com.sensiblemetrics.api.alpenidos.pattern.abstract_factory3;

import com.sensiblemetrics.api.alpenidos.pattern.abstract_factory3.factory.GUIFactory;
import com.sensiblemetrics.api.alpenidos.pattern.abstract_factory3.factory.MacOSFactory;
import com.sensiblemetrics.api.alpenidos.pattern.abstract_factory3.factory.WindowsFactory;
import com.sensiblemetrics.api.alpenidos.pattern.abstract_factory3.management.Application;

/**
 * EN: Demo class. Everything comes together here.
 * <p>
 * RU: Демо-класс. Здесь всё сводится воедино.
 */
public class Demo {

    /**
     * EN: Application picks the factory type and creates it in run time (usually at initialization stage), depending on the configuration or environment
     * variables.
     * <p>
     * RU: Приложение выбирает тип и создаёт конкретные фабрики динамически исходя из конфигурации или окружения.
     */
    private static Application configureApplication() {
        Application app;
        GUIFactory factory;

        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacOSFactory();
            app = new Application(factory);
        } else {
            factory = new WindowsFactory();
            app = new Application(factory);
        }
        return app;
    }

    public static void main(final String[] args) {
        final Application app = configureApplication();
        app.paint();
    }
}
