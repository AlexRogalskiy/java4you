package com.sensiblemetrics.api.alpenidos.pattern.spring_boot.service.strategy;

import com.sensiblemetrics.api.alpenidos.pattern.spring_boot.enums.Bank;
import com.sensiblemetrics.api.alpenidos.pattern.spring_boot.model.BankInformation;
import lombok.RequiredArgsConstructor;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Created by indrek.ruubel on 02/07/2016.
 */
@RequiredArgsConstructor
public class SebScraper implements BankScraperStrategy {
    private static final String bankUrl = "http://www.seb.ee/eng/contact/contact";
    private final HttpFetchService httpFetchService;

    @Override
    public BankInformation scrape() {
        String number = "FAILED";
        try {
            final Document doc = this.httpFetchService.get(this.bankUrl);
            final Elements content = doc.select(".field-type-text-with-summary");
            final Elements tables = content.get(0).select("table");
            final Elements tds = tables.get(0).select("td");
            number = tds.get(3).text();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new BankInformation(Bank.SEB, number);
    }
}
