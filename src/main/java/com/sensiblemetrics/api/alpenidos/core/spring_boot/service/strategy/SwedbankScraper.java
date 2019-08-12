package com.sensiblemetrics.api.alpenidos.core.spring_boot.service.strategy;

import com.sensiblemetrics.api.alpenidos.core.spring_boot.enums.Bank;
import com.sensiblemetrics.api.alpenidos.core.spring_boot.model.BankInformation;
import lombok.RequiredArgsConstructor;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by indrek.ruubel on 02/07/2016.
 */
@RequiredArgsConstructor
public class SwedbankScraper implements BankScraperStrategy {
    private static final String bankUrl = "https://www.swedbank.ee/private/home/more/channels?language=EST";
    private final HttpFetchService httpFetchService;

    @Override
    public BankInformation scrape() {
        String number = "FAILED";
        try {
            final Document doc = this.httpFetchService.get(this.bankUrl);
            final Elements footers = doc.select("section.footer-section");
            final Element tel = footers.get(0).select("div.tel").get(0);
            number = tel.text();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new BankInformation(Bank.SWEDBANK, number);
    }
}
