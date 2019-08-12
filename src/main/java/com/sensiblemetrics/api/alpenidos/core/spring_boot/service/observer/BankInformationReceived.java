package com.sensiblemetrics.api.alpenidos.core.spring_boot.service.observer;

import com.sensiblemetrics.api.alpenidos.core.spring_boot.model.BankInformation;

import java.util.List;

/**
 * Created by indrek.ruubel on 03/07/2016.
 * <p>
 * All services that subscribe to BankInformationPublisherService for updates need to implement
 * this interface to receive updates.
 */
public interface BankInformationReceived {

    void receivedBankInformation(final List<BankInformation> data);
}
