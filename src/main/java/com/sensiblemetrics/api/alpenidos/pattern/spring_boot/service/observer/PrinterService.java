package com.sensiblemetrics.api.alpenidos.pattern.spring_boot.service.observer;

import com.sensiblemetrics.api.alpenidos.pattern.spring_boot.model.BankInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by indrek.ruubel on 03/07/2016.
 * <p>
 * This service is very interested in events that take place in BankService,
 * so it subscribes itself to BankInformationPublisherService.
 * This service chooses to print out the results (for demo sake).
 */
@Service
public class PrinterService implements BankInformationReceived {
    private final BankInformationPublisherService bankInformationPublisherService;

    @Autowired
    public PrinterService(final BankInformationPublisherService bankInformationPublisherService) {
        this.bankInformationPublisherService = bankInformationPublisherService;
        this.bankInformationPublisherService.subscribe(this);
    }

    @Override
    public void receivedBankInformation(final List<BankInformation> data) {
        System.out.println("Printing: " + data);
    }
}
