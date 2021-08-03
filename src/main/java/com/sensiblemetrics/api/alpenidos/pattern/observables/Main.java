package com.sensiblemetrics.api.alpenidos.pattern.observables;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import cyclops.control.Try;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.nio.client.methods.HttpAsyncMethods;
import rx.Observable;
import rx.apache.http.ObservableHttp;
import rx.schedulers.Schedulers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

public class Main {

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    @EqualsAndHashCode
    @ToString
    static class SensorTemperature {
        private Double temperature;
        private String sensorName;
    }

    public static void main(String[] args) throws Exception {
        final RequestConfig requestConfig = RequestConfig.custom()
            .setSocketTimeout(3000)
            .setConnectTimeout(500).build();
        final CloseableHttpAsyncClient httpClient = HttpAsyncClients.custom()
            .setDefaultRequestConfig(requestConfig)
            .setMaxConnPerRoute(20)
            .setMaxConnTotal(50)
            .build();
        httpClient.start();

        Observable.range(1, 5).map(x ->
            Try.withCatch(() -> new URI("http", null, "127.0.0.1", 8080 + x, "/sensor", null, null), URISyntaxException.class)
                .orElse(null))
            .flatMap(address -> ObservableHttp.createRequest(HttpAsyncMethods.createGet(address), httpClient)
                .toObservable())
            .flatMap(response -> response.getContent().map(bytes -> new String(bytes)))
            .onErrorReturn(error -> "{\"temperature\":0,\"sensorName\":\"\"}")
            .map(json ->
                Try.withCatch(() -> new ObjectMapper().readValue(json, SensorTemperature.class), Exception.class)
                    .orElse(new SensorTemperature()))
            .repeatWhen(observable -> observable.delay(500, TimeUnit.MILLISECONDS))
            .subscribeOn(Schedulers.io())
            .subscribe(x -> {
                if (x.getTemperature() > 90) {
                    System.out.println("Temperature warning for " + x.getSensorName());
                } else {
                    System.out.println(x.toString());
                }
            }, Throwable::printStackTrace);
    }

}
