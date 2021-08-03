package com.sensiblemetrics.api.alpenidos.pattern.factory3.management;

import com.sensiblemetrics.api.alpenidos.pattern.factory3.model.GuaranteedIncomeBond;
import com.sensiblemetrics.api.alpenidos.pattern.factory3.model.Product;
import com.sensiblemetrics.api.alpenidos.pattern.factory3.model.SavingsDepositAccount;

/**
 * Concrete factory implementation for building investment savings Products, e.g. Building Society accounts, Guaranteed Income Bonds, Premium Bonds
 */
public class InvestmentSavingsFactory extends InvestmentFactory {

    @Override
    protected Product createProduct(ProductType productType) {
        if (productType == ProductType.GUARANTEED_INCOME_BOND) {
            return new GuaranteedIncomeBond();
        } else if (productType == ProductType.CASH_SAVINGS_ACCOUNT) {
            return new SavingsDepositAccount();
        }
        throw new IllegalArgumentException("Can't build unknown productType: " + productType);
    }
}
