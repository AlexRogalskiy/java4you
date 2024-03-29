package com.sensiblemetrics.api.alpenidos.pattern.enterprise.wire_tap;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * In most integration cases there is a need to monitor the messages flowing through the system. It is usually achieved
 * by intercepting the message and redirecting it to a different location like console, filesystem or the database.
 * It is important that such functionality should not modify the original message and influence the processing path.
 *
 * <p>
 * Wire Tap allows you to route messages to a separate location while they are being forwarded to the ultimate
 * destination. It basically consumes messages of the input channel and publishes the unmodified message to both
 * output channels.
 * </p>
 */
@SpringBootApplication
public class WireTapPatternLoader {

    /**
     * Program entry point. It starts Spring Boot application and using Apache Camel it auto-configures routes.
     *
     * @param args command line args
     */
    public static void main(final String[] args) throws Exception {
        // Run Spring Boot application and obtain ApplicationContext
        final ConfigurableApplicationContext context = SpringApplication.run(WireTapPatternLoader.class, args);

        // Get CamelContext from ApplicationContext
        final CamelContext camelContext = (CamelContext) context.getBean("camelContext");

        // Add a new routes that will handle endpoints form WireTapRoute class.
        camelContext.addRoutes(new RouteBuilder() {

            @Override
            public void configure() {
                from("{{endpoint}}").log("ENDPOINT: ${body}");
                from("{{wireTapEndpoint}}").log("WIRETAPPED ENDPOINT: ${body}");
            }

        });

        // Add producer that will send test message to an entry point in WireTapRoute
        camelContext.createProducerTemplate().sendBody("{{entry}}", "Test message");

        SpringApplication.exit(context);
    }
}
