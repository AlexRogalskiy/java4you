package com.sensiblemetrics.api.alpenidos.core.serverless.faas.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * Lambda context information
 */
@Data
@EqualsAndHashCode
@ToString
public class LambdaInfo implements Serializable {

    private static final long serialVersionUID = 3936130599040848923L;

    private String awsRequestId;
    private String logGroupName;
    private String logStreamName;
    private String functionName;
    private String functionVersion;
    private Integer memoryLimitInMb;
}
