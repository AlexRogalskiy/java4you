package com.sensiblemetrics.api.alpenidos.core.abstract_factory2.factory;

import com.sensiblemetrics.api.alpenidos.core.abstract_factory2.account.Account;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory2.account.StandardAccount;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory2.address.Address;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory2.address.DomicileAddress;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory2.product.Product;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory2.product.TaxableInvestmentFund;

/**
 * Concrete factory for creating our objects for the Onshore Investment Customer 'family'.
 */
public class OnshoreInvestmentCustomerFactory extends AbstractCustomerFactory {

    @Override
    public Address createAddress() {
        return new DomicileAddress();
    }

    @Override
    public Account createAccount() {
        return new StandardAccount();
    }

    @Override
    public Product createProduct() {
        return new TaxableInvestmentFund();
    }
}
