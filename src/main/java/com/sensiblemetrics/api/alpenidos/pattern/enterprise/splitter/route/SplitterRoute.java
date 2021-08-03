package com.sensiblemetrics.api.alpenidos.pattern.enterprise.splitter.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Sample splitter route definition.
 *
 * <p>
 * It consumes messages out of the <i>direct:entry</i> entry point and forwards them to <i>direct:endpoint</i>.
 * Route accepts messages having body of array or collection of objects. Splitter component split message body and
 * forwards single objects to the endpoint.
 * </p>
 * <p>
 * In this example input/output endpoints names are stored in <i>application.properties</i> file.
 */
@Component
public class SplitterRoute extends RouteBuilder {

    /**
     * Configures the route
     */
    @Override
    public void configure() {
        // TrampolinePatternLoader route
        from("{{entry}}").split().body().to("{{endpoint}}");
    }
}
