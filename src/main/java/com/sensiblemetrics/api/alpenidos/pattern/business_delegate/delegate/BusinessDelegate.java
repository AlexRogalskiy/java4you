package com.sensiblemetrics.api.alpenidos.pattern.business_delegate.delegate;

import com.sensiblemetrics.api.alpenidos.pattern.business_delegate.enums.ServiceType;
import com.sensiblemetrics.api.alpenidos.pattern.business_delegate.iface.BusinessService;

/**
 * BusinessDelegate separates the presentation and business tiers
 */
public class BusinessDelegate {
    private BusinessService businessService;
    private BusinessLookup lookupService;
    private ServiceType serviceType;

    public void setLookupService(final BusinessLookup businessLookup) {
        this.lookupService = businessLookup;
    }

    public void setServiceType(final ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public void doTask() {
        this.businessService = this.lookupService.getBusinessService(this.serviceType);
        this.businessService.doProcessing();
    }
}
