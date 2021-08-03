package com.sensiblemetrics.api.alpenidos.pattern.test.spring_boot.service.observer

import com.sensiblemetrics.api.alpenidos.core.spring_boot.model.BankInformation
import com.sensiblemetrics.api.alpenidos.core.spring_boot.service.observer.BankInformationPublisherService
import com.sensiblemetrics.api.alpenidos.core.spring_boot.service.observer.BankInformationReceived
import spock.lang.Specification

class BankInformationPublisherServiceSpec extends Specification {
    private BankInformationPublisherService service

    def setup() {
        service = new BankInformationPublisherService()
    }

    def "when subscribes, then gets added to internal subscriber list"() {
        given:
        BankInformationReceived subscriber = Mock(BankInformationReceived)
        when:
        service.subscribe(subscriber)
        then:
        service.subscribers == [subscriber]
    }

    def "when data is published, then subscriber receives data"() {
        given:
        List<BankInformation> data = [new BankInformation(Bank.SEB, "12345")]
        BankInformationReceived subscriber = Mock(BankInformationReceived)
        service.subscribe(subscriber)
        when:
        service.publish(data)
        then:
        1 * subscriber.receivedBankInformation(data)
    }

    def "when subscriber unsubscribes, internal list becomes empty"() {
        given:
        BankInformationReceived subscriber = Mock(BankInformationReceived)
        service.subscribe(subscriber)
        when:
        service.unsubscribe(subscriber)
        then:
        service.subscribers == []
    }
}
