package com.sensiblemetrics.api.alpenidos.core.test.spring_boot.service.strategy

import com.sensiblemetrics.api.alpenidos.core.spring_boot.model.BankInformation
import com.sensiblemetrics.api.alpenidos.core.spring_boot.service.strategy.HttpFetchService
import com.sensiblemetrics.api.alpenidos.core.spring_boot.service.strategy.SwedbankScraper
import org.jsoup.Jsoup
import spock.lang.Specification

class SwebankScraperSpec extends Specification {
    private SwedbankScraper scraper
    private HttpFetchService httpFetchService

    def setup() {
        httpFetchService = Mock(HttpFetchService)
        scraper = new SwedbankScraper(httpFetchService)
    }

    def "when fetches not expected HTML, then phoneNumber is FAILED"() {
        given:
        httpFetchService.get(_) >> Jsoup.parse("<div class=\"field-type-text-with-summary\">" +
            "<table><td></td><td></td><td></td></table></div>")
        when:
        BankInformation bankInformation = scraper.scrape()
        then:
        bankInformation.getBank() == Bank.SWEDBANK
        bankInformation.getPhoneNumber() == "FAILED"
    }

    def "when fetches expected HTML, then retrieves the phoneNumber as expected"() {
        given:
        String phoneNumber = "12345"
        httpFetchService.get(_) >> Jsoup.parse("<section class=\"footer-section\">" +
            "<div class=\"tel\">" + phoneNumber + "</div></section>")
        when:
        BankInformation bankInformation = scraper.scrape()
        then:
        bankInformation.getBank() == Bank.SWEDBANK
        bankInformation.getPhoneNumber() == phoneNumber
    }
}
