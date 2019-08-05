package com.sensiblemetrics.api.alpenidos.core.serverless.faas.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.common.collect.ImmutableMap;
import com.sensiblemetrics.api.alpenidos.core.serverless.faas.ApiGatewayResponse;
import com.sensiblemetrics.api.alpenidos.core.serverless.faas.model.LambdaInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * LambdaInfoApiHandler - simple api to get lambda context
 * Created by dheeraj.mummar on 2/5/18.
 */
@Slf4j
public class LambdaInfoApiHandler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {
    private static final Integer SUCCESS_STATUS_CODE = 200;

    @Override
    public ApiGatewayResponse handleRequest(final Map<String, Object> input, final Context context) {
        log.info("received: " + input);
        return new ApiGatewayResponse
            .ApiGatewayResponseBuilder<LambdaInfo>()
            .headers(headers())
            .statusCode(SUCCESS_STATUS_CODE)
            .body(lambdaInfo(context))
            .build();
    }

    /**
     * lambdaInfo
     *
     * @param context - Lambda context
     * @return LambdaInfo
     */
    private LambdaInfo lambdaInfo(final Context context) {
        final LambdaInfo lambdaInfo = new LambdaInfo();
        lambdaInfo.setAwsRequestId(context.getAwsRequestId());
        lambdaInfo.setFunctionName(context.getFunctionName());
        lambdaInfo.setFunctionVersion(context.getFunctionVersion());
        lambdaInfo.setLogGroupName(context.getLogGroupName());
        lambdaInfo.setLogStreamName(context.getLogStreamName());
        lambdaInfo.setMemoryLimitInMb(context.getMemoryLimitInMB());
        return lambdaInfo;
    }

    private Map<String, String> headers() {
        return ImmutableMap.<String, String>builder()
            .put("Content-Type", "application/json")
            .build();
    }
}
