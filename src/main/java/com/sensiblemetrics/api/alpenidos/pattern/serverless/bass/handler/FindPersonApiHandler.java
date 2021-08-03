package com.sensiblemetrics.api.alpenidos.pattern.serverless.bass.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.sensiblemetrics.api.alpenidos.pattern.serverless.bass.model.Person;
import lombok.extern.slf4j.Slf4j;

/**
 * find person from persons collection
 * Created by dheeraj.mummar on 3/5/18.
 */
@Slf4j
public class FindPersonApiHandler extends AbstractDynamoDbHandler<Person> implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    private static final Integer SUCCESS_STATUS_CODE = 200;

    @Override
    public APIGatewayProxyResponseEvent handleRequest(final APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent, final Context context) {
        log.info("Gateway request event params: {}", apiGatewayProxyRequestEvent.getPathParameters());
        final Person person = this.getDynamoDbMapper().load(Person.class, apiGatewayProxyRequestEvent.getPathParameters().get("id"));
        return apiGatewayProxyResponseEvent(SUCCESS_STATUS_CODE, person);
    }
}
