package com.sensiblemetrics.api.alpenidos.core.spring_boot.service.observer;

import com.sensiblemetrics.api.alpenidos.core.spring_boot.model.BankInformation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by indrek.ruubel on 03/07/2016.
 * <p>
 * Observer pattern:
 * Defines a one-to-many dependency between objects so that when one object changes state,
 * all its dependents are notified and updated automatically.
 * https://www.oodesign.com/observer-pattern.html
 */
@Service
public class BankInformationPublisherService {
    private final List<BankInformationReceived> subscribers;

    public BankInformationPublisherService() {
        this.subscribers = new ArrayList<>();
    }

    /**
     * Services can "sign up" here to receive updates
     *
     * @param subscriber
     */
    public void subscribe(final BankInformationReceived subscriber) {
        this.subscribers.add(subscriber);
    }

    /**
     * Service can "opt-out" from receiving these updates
     *
     * @param subscriber
     */
    public void unsubscribe(final BankInformationReceived subscriber) {
        this.subscribers.remove(subscriber);
    }

    /**
     * This is called when desired event happens, all subscribers will be informed
     */
    public void publish(List<BankInformation> data) {
        this.subscribers.forEach(s -> s.receivedBankInformation(data));
    }
}
