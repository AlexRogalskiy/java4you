package com.sensiblemetrics.api.alpenidos.core.spring_boot.service.factory;

import com.sensiblemetrics.api.alpenidos.core.spring_boot.service.strategy.BankScraperStrategy;
import com.sensiblemetrics.api.alpenidos.core.spring_boot.service.strategy.HttpFetchService;
import com.sensiblemetrics.api.alpenidos.core.spring_boot.service.strategy.SebScraper;
import com.sensiblemetrics.api.alpenidos.core.spring_boot.service.strategy.SwedbankScraper;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by indrek.ruubel on 03/07/2016.
 * <p>
 * Factory pattern:
 * - creates objects without exposing the instantiation logic to the client.
 * - refers to the newly created object through a common interface
 * https://www.oodesign.com/factory-pattern.html
 */
@Service
public class ScraperFactoryService {
    private List<BankScraperStrategy> strategies;
    private HttpFetchService httpFetchService;

    public ScraperFactoryService() {
        this.httpFetchService = new HttpFetchService();
        this.strategies = createStrategies();
    }

    /**
     * Internally creates objects, does not expose instantiation logic to the client.
     */
    private List<BankScraperStrategy> createStrategies() {
        return asList(
            new SebScraper(this.httpFetchService),
            new SwedbankScraper(this.httpFetchService)
        );
    }

    /**
     * Refers to the newly created object through a common interface
     */
    public List<BankScraperStrategy> getStrategies() {
        return this.strategies;
    }
}
