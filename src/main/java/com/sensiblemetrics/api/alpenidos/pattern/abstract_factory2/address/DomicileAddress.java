package com.sensiblemetrics.api.alpenidos.pattern.abstract_factory2.address;

public class DomicileAddress implements Address {

    @Override
    public String getAddressDetails() {
        return "Domicile Address details with UK specific bit n pieces";
    }
}
