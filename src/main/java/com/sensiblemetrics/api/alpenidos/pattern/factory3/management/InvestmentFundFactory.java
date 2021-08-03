package com.sensiblemetrics.api.alpenidos.pattern.factory3.management;

import com.sensiblemetrics.api.alpenidos.pattern.factory3.model.Gilt;
import com.sensiblemetrics.api.alpenidos.pattern.factory3.model.InvestmentTrust;
import com.sensiblemetrics.api.alpenidos.pattern.factory3.model.Oeic;
import com.sensiblemetrics.api.alpenidos.pattern.factory3.model.Product;

/**
 * Concrete factory implementation for building investment fund Products, e.g. OEICs, Gilts, Investment Trusts
 */
public class InvestmentFundFactory extends InvestmentFactory {

    @Override
    protected Product createProduct(ProductType productType) {
        if (productType == ProductType.GILT) {
            return new Gilt();
        } else if (productType == ProductType.OEIC) {
            return new Oeic();
        } else if (productType == ProductType.INVESTMENT_TRUST) {
            return new InvestmentTrust();
        }
        throw new IllegalArgumentException("Can't build unknown productType: " + productType);
    }
}
