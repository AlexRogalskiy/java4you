package com.sensiblemetrics.api.alpenidos.pattern.serverless.bass.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.sensiblemetrics.api.alpenidos.pattern.serverless.bass.model.Person;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * save person into persons collection
 * Created by dheeraj.mummar on 3/4/18.
 */
@Slf4j
public class SavePersonApiHandler extends AbstractDynamoDbHandler<Person> implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    private static final Integer CREATED_STATUS_CODE = 201;
    private static final Integer BAD_REQUEST_STATUS_CODE = 400;

    @Override
    public APIGatewayProxyResponseEvent handleRequest(final APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent, final Context context) {
        APIGatewayProxyResponseEvent apiGatewayProxyResponseEvent;
        Person person;
        try {
            person = getObjectMapper().readValue(apiGatewayProxyRequestEvent.getBody(), Person.class);
            this.getDynamoDbMapper().save(person);
            apiGatewayProxyResponseEvent = apiGatewayProxyResponseEvent(CREATED_STATUS_CODE, person);
        } catch (IOException ioException) {
            log.error("unable to parse body", ioException);
            apiGatewayProxyResponseEvent = apiGatewayProxyResponseEvent(BAD_REQUEST_STATUS_CODE, null);
        }
        return apiGatewayProxyResponseEvent;
    }
}
