package com.sensiblemetrics.api.alpenidos.pattern.test.spring_boot.service.strategy

import com.sensiblemetrics.api.alpenidos.core.spring_boot.model.BankInformation
import com.sensiblemetrics.api.alpenidos.core.spring_boot.service.strategy.HttpFetchService
import com.sensiblemetrics.api.alpenidos.core.spring_boot.service.strategy.SebScraper
import org.jsoup.Jsoup
import spock.lang.Specification

class SebScraperSpec extends Specification {
    private SebScraper scraper
    private HttpFetchService httpFetchService

    def setup() {
        httpFetchService = Mock(HttpFetchService)
        scraper = new SebScraper(httpFetchService)
    }

    def "when fetches not expected HTML, then phoneNumber is FAILED"() {
        given:
        httpFetchService.get(_) >> Jsoup.parse("<div class=\"field-type-text-with-summary\">" +
            "<table><td></td><td></td><td></td></table></div>")
        when:
        BankInformation bankInformation = scraper.scrape()
        then:
        bankInformation.getBank() == Bank.SEB
        bankInformation.getPhoneNumber() == "FAILED"
    }

    def "when fetches expected HTML, then retrieves the phoneNumber as expected"() {
        given:
        String phoneNumber = "12345"
        httpFetchService.get(_) >> Jsoup.parse("<div class=\"field-type-text-with-summary\">" +
            "<table><td></td><td></td><td></td><td>" + phoneNumber + "</td></table></div>")
        when:
        BankInformation bankInformation = scraper.scrape()
        then:
        bankInformation.getBank() == Bank.SEB
        bankInformation.getPhoneNumber() == phoneNumber
    }
}
