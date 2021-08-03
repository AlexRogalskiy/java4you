package com.sensiblemetrics.api.alpenidos.pattern.spring_boot.service.strategy;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * A wrapper service for testing purposes
 */
public class HttpFetchService {

    public Document get(final String url) throws IOException {
        return Jsoup.connect(url).get();
    }
}
