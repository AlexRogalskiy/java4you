package com.sensiblemetrics.api.alpenidos.core.business_delegate.delegate;

import com.sensiblemetrics.api.alpenidos.core.business_delegate.enums.ServiceType;
import com.sensiblemetrics.api.alpenidos.core.business_delegate.iface.BusinessService;
import com.sensiblemetrics.api.alpenidos.core.business_delegate.impl.EjbService;
import com.sensiblemetrics.api.alpenidos.core.business_delegate.impl.JmsService;
import lombok.Setter;

/**
 * Class for performing service lookups.
 */
@Setter
public class BusinessLookup {
    private EjbService ejbService;
    private JmsService jmsService;

    /**
     * @param serviceType Type of service instance to be returned.
     * @return Service instance.
     */
    public BusinessService getBusinessService(ServiceType serviceType) {
        if (serviceType.equals(ServiceType.EJB)) {
            return this.ejbService;
        }
        return this.jmsService;
    }
}
