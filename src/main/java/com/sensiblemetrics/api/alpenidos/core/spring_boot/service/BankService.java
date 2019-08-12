package com.sensiblemetrics.api.alpenidos.core.spring_boot.service;

import com.sensiblemetrics.api.alpenidos.core.spring_boot.model.BankInformation;
import com.sensiblemetrics.api.alpenidos.core.spring_boot.service.factory.ScraperFactoryService;
import com.sensiblemetrics.api.alpenidos.core.spring_boot.service.observer.BankInformationPublisherService;
import com.sensiblemetrics.api.alpenidos.core.spring_boot.service.strategy.BankScraperStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by indrek.ruubel on 02/07/2016.
 */
@Service
@RequiredArgsConstructor
public class BankService {
    private final BankInformationPublisherService bankInformationPublisherService;
    private final ScraperFactoryService scraperFactoryService;

    public List<BankInformation> getContacts() {
        final List<BankInformation> bankInformations = this.scraperFactoryService.getStrategies().stream().map(BankScraperStrategy::scrape).collect(Collectors.toList());
        this.bankInformationPublisherService.publish(bankInformations);
        return bankInformations;
    }
}
