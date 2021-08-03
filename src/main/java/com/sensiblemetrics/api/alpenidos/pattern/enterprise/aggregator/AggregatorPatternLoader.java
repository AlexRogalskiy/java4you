package com.sensiblemetrics.api.alpenidos.pattern.enterprise.aggregator;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Sometimes in enterprise systems there is a need to group incoming data in order to process it as a whole. For example
 * you may need to gather offers and after defined number of offers has been received you would like to choose the one
 * with the best parameters.
 *
 * <p>
 * Aggregator allows you to merge messages based on defined criteria and parameters. It gathers original messages,
 * applies aggregation strategy and upon fulfilling given criteria, releasing merged messages.
 * </p>
 */
@SpringBootApplication
public class AggregatorPatternLoader {

    /**
     * Program entry point. It starts Spring Boot application and using Apache Camel it auto-configures routes.
     *
     * @param args command line args
     */
    public static void main(final String[] args) throws Exception {
        // Run Spring Boot application and obtain ApplicationContext
        final ConfigurableApplicationContext context = SpringApplication.run(AggregatorPatternLoader.class, args);
        // Get CamelContext from ApplicationContext
        final CamelContext camelContext = (CamelContext) context.getBean("camelContext");
        // Add a new routes that will handle endpoints form SplitterRoute class.
        camelContext.addRoutes(new RouteBuilder() {
            @Override
            public void configure() {
                from("{{endpoint}}").log("ENDPOINT: ${body}");
            }
        });

        // Add producer that will send test message to an entry point in WireTapRoute
        final String[] stringArray = {"Test item #1", "Test item #2", "Test item #3"};
        camelContext.createProducerTemplate().sendBody("{{entry}}", stringArray);
        SpringApplication.exit(context);
    }
}
