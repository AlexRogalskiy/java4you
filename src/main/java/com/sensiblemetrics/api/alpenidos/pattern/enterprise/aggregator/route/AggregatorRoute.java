package com.sensiblemetrics.api.alpenidos.pattern.enterprise.aggregator.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Sample aggregator route definition.
 *
 * <p>
 * It consumes messages out of the <i>direct:entry</i> entry point and forwards them to <i>direct:endpoint</i>.
 * Route accepts messages containing String as a body, it aggregates the messages based on the settings and forwards
 * them as CSV to the output chanel.
 * <p>
 * Settings for the aggregation are: aggregate until 3 messages are bundled or wait 2000ms before sending bundled
 * messages further.
 * </p>
 * <p>
 * In this example input/output endpoints names are stored in <i>application.properties</i> file.
 */
@Component
public class AggregatorRoute extends RouteBuilder {

    @Autowired
    private MessageAggregationStrategy aggregator;

    /**
     * Configures the route
     *
     * @throws Exception in case of exception during configuration
     */
    @Override
    public void configure() {
        // TrampolinePatternLoader route
        from("{{entry}}")
            .aggregate(constant(true), this.aggregator)
            .completionSize(3).completionInterval(2000)
            .to("{{endpoint}}");
    }
}
