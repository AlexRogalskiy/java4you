package com.sensiblemetrics.api.alpenidos.pattern.serverless.bass.handler;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;

import java.io.Serializable;
import java.util.Map;

/**
 * abstract dynamodb handler
 *
 * @param <T> - serializable collection
 */
public abstract class AbstractDynamoDbHandler<T extends Serializable> {
    private DynamoDBMapper dynamoDbMapper;
    private ObjectMapper objectMapper;

    public AbstractDynamoDbHandler() {
        this.initAmazonDynamoDb();
        this.objectMapper = new ObjectMapper();
    }

    private void initAmazonDynamoDb() {
        final AmazonDynamoDB amazonDynamoDb = AmazonDynamoDBClientBuilder
            .standard()
            .withRegion(Regions.US_EAST_1)
            .build();
        this.dynamoDbMapper = new DynamoDBMapper(amazonDynamoDb);
    }

    protected DynamoDBMapper getDynamoDbMapper() {
        return this.dynamoDbMapper;
    }

    protected ObjectMapper getObjectMapper() {
        return this.objectMapper;
    }

    public void setDynamoDbMapper(DynamoDBMapper dynamoDbMapper) {
        this.dynamoDbMapper = dynamoDbMapper;
    }

    protected Map<String, String> headers() {
        return ImmutableMap.<String, String>builder()
            .put("Content-Type", "application/json")
            .build();
    }

    /**
     * API Gateway response
     *
     * @param statusCode - status code
     * @param body       - Object body
     * @return - api gateway proxy response
     */
    protected APIGatewayProxyResponseEvent apiGatewayProxyResponseEvent(final Integer statusCode, final T body) {
        final APIGatewayProxyResponseEvent apiGatewayProxyResponseEvent = new APIGatewayProxyResponseEvent().withHeaders(headers());
        try {
            apiGatewayProxyResponseEvent
                .withStatusCode(statusCode)
                .withBody(getObjectMapper()
                    .writeValueAsString(body)
                );
        } catch (JsonProcessingException ex) {
            throw new IllegalArgumentException(ex);
        }
        return apiGatewayProxyResponseEvent;
    }
}
