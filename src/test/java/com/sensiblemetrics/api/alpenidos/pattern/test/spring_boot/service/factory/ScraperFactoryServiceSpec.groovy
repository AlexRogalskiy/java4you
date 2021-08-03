package com.sensiblemetrics.api.alpenidos.pattern.test.spring_boot.service.factory;

import com.sensiblemetrics.api.alpenidos.core.spring_boot.service.factory.ScraperFactoryService
import com.sensiblemetrics.api.alpenidos.core.spring_boot.service.strategy.BankScraperStrategy
import spock.lang.Specification

class ScraperFactoryServiceSpec extends Specification {
    private ScraperFactoryService service

    def setup() {
        service = new ScraperFactoryService()
    }

    def "when service is initialized, then has strategies setup"() {
        expect:
        service.strategies.size() == 2
    }

    def "when getting strategies, then returns the exact list"() {
        when:
        List<BankScraperStrategy> strategies = service.getStrategies()
        then:
        service.strategies == strategies
    }
}
