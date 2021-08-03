package com.sensiblemetrics.api.alpenidos.pattern.abstract_factory2.address;

public class OffshoreAddress implements Address {

    @Override
    public String getAddressDetails() {
        return "Offshore Address details with special 'PO Box' info... ;-)";
    }
}
