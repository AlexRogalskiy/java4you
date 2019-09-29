package com.sensiblemetrics.api.alpenidos.core.aggregator.aggregator_service.impl;

import com.sensiblemetrics.api.alpenidos.core.aggregator.aggregator_service.iface.ProductInventoryClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * An adapter to communicate with inventory micro-service.
 */
@Slf4j
@Component
public class ProductInventoryClientImpl implements ProductInventoryClient {

    @Override
    public int getProductInventories() {
        String response = "0";
        try (final CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet("http://localhost:51516/inventories");
            try (CloseableHttpResponse httpResponse = httpClient.execute(httpGet)) {
                response = EntityUtils.toString(httpResponse.getEntity());
            }
        } catch (IOException e) {
            log.error("Exception caught.", e);
        }
        return Integer.parseInt(response);
    }
}
