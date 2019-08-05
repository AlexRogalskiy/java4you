package com.sensiblemetrics.api.alpenidos.core.serverless.faas;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Map;

/**
 * Api gateway response
 *
 * @param <T> serializable object
 */
@Data
@RequiredArgsConstructor
public class ApiGatewayResponse<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = 1181159426782844892L;

    private final Integer statusCode;
    private final String body;
    private final Map<String, String> headers;
    private final Boolean isBase64Encoded;

    /**
     * ApiGatewayResponse Builder class
     *
     * @param <T> Serializable object
     */
    public static class ApiGatewayResponseBuilder<T extends Serializable> {
        private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
        private Integer statusCode;
        private T body;
        private Map<String, String> headers;
        private Boolean isBase64Encoded;

        /**
         * http status code
         *
         * @param statusCode - http status code
         * @return ApiGatewayResponseBuilder
         */
        public ApiGatewayResponseBuilder statusCode(final Integer statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        /**
         * Serializable body
         *
         * @param body - Serializable object
         * @return ApiGatewayResponseBuilder
         */
        public ApiGatewayResponseBuilder body(final T body) {
            this.body = body;
            return this;
        }

        /**
         * response headers
         *
         * @param headers - response headers
         * @return ApiGatewayResponseBuilder
         */
        public ApiGatewayResponseBuilder headers(final Map<String, String> headers) {
            this.headers = headers;
            return this;
        }

        /**
         * base64Encoded glag
         *
         * @param isBase64Encoded - base64Encoded flag
         * @return ApiGatewayResponseBuilder
         */
        public ApiGatewayResponseBuilder base64Encoded(final Boolean isBase64Encoded) {
            this.isBase64Encoded = isBase64Encoded;
            return this;
        }

        /**
         * build ApiGatewayResponse
         *
         * @return ApiGatewayResponse
         */
        public ApiGatewayResponse build() {
            String strBody = null;
            if (this.body != null) {
                try {
                    strBody = OBJECT_MAPPER.writeValueAsString(this.body);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
            return new ApiGatewayResponse(this.statusCode, strBody, this.headers, this.isBase64Encoded);
        }
    }
}
