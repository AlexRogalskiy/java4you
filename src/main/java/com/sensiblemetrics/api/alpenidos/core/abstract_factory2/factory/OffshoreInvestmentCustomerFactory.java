package com.sensiblemetrics.api.alpenidos.core.abstract_factory2.factory;

import com.sensiblemetrics.api.alpenidos.core.abstract_factory2.account.Account;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory2.account.PlatinumAccount;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory2.address.Address;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory2.address.OffshoreAddress;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory2.product.Product;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory2.product.TaxExemptInvestmentFund;

/**
 * Concrete factory for creating our objects for the Offshore Investment Customer 'family'.
 */
public class OffshoreInvestmentCustomerFactory extends AbstractCustomerFactory {

    @Override
    public Address createAddress() {
        return new OffshoreAddress();
    }

    @Override
    public Account createAccount() {
        return new PlatinumAccount();
    }

    @Override
    public Product createProduct() {
        return new TaxExemptInvestmentFund();
    }
}
