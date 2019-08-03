package com.sensiblemetrics.api.alpenidos.core.enterprise.aggregator.route;

import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

/**
 * Aggregation strategy joining bodies of messages. If message is first one <i>oldMessage</i> is null. All changes are
 * made on IN messages.
 */
@Component
public class MessageAggregationStrategy implements AggregationStrategy {

    @Override
    public Exchange aggregate(final Exchange oldExchange, final Exchange newExchange) {
        if (oldExchange == null) {
            return newExchange;
        }
        final String in1 = (String) oldExchange.getIn().getBody();
        final String in2 = (String) newExchange.getIn().getBody();
        oldExchange.getIn().setBody(in1 + ";" + in2);
        return oldExchange;
    }
}
