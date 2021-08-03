package com.sensiblemetrics.api.alpenidos.pattern.test.spring_boot.service

import com.sensiblemetrics.api.alpenidos.core.spring_boot.model.BankInformation
import com.sensiblemetrics.api.alpenidos.core.spring_boot.service.BankService
import com.sensiblemetrics.api.alpenidos.core.spring_boot.service.factory.ScraperFactoryService
import com.sensiblemetrics.api.alpenidos.core.spring_boot.service.observer.BankInformationPublisherService
import com.sensiblemetrics.api.alpenidos.core.spring_boot.service.strategy.BankScraperStrategy
import spock.lang.Specification

public class BankServiceSpec extends Specification {
    private BankService service
    private BankInformationPublisherService bankInformationPublisherService
    private ScraperFactoryService scraperFactoryService

    def setup() {
        this.bankInformationPublisherService = Mock(BankInformationPublisherService)
        this.scraperFactoryService = Mock(ScraperFactoryService)
        this.service = new BankService(bankInformationPublisherService, scraperFactoryService)
    }

    def "when empty list of strategies is defined, then scrapes none, publishes and returns empty list"() {
        when:
        List<BankInformation> contacts = service.getContacts()
        then:
        1 * this.service.scraperFactoryService.getStrategies() >> []
        1 * this.bankInformationPublisherService.publish([])
        contacts == []
    }

    def "when strategy is defined, then scrapes it, publishes and returns on element list"() {
        given:
        BankScraperStrategy scraper = Mock(BankScraperStrategy)
        BankInformation scrapeResult = new BankInformation(Bank.SEB, "12345")
        when:
        List<BankInformation> contacts = service.getContacts()
        then:
        1 * this.scraperFactoryService.getStrategies() >> [scraper]
        1 * scraper.scrape() >> scrapeResult
        1 * this.bankInformationPublisherService.publish([scrapeResult])
        contacts == [scrapeResult]
    }
}
