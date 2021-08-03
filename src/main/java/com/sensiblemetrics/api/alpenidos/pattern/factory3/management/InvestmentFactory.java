package com.sensiblemetrics.api.alpenidos.pattern.factory3.management;

import com.sensiblemetrics.api.alpenidos.pattern.factory3.model.Product;

/**
 * This is the abstract factory the Client code uses to build different Product types.
 * <p>
 * Concrete factories subclass this to build/instantiate the actual Product objects.
 */
public abstract class InvestmentFactory {

    /**
     * Some sample financial investment products for purposes of the demo
     */
    public enum ProductType {
        OEIC,
        GILT,
        INVESTMENT_TRUST,
        CASH_SAVINGS_ACCOUNT,
        GUARANTEED_INCOME_BOND
    }

    /**
     * This is the business method for the Client code to call to create Products.
     * <p>
     * FYI: An ISA (individual Savings Account) is a tax free investment vehicle used in the UK.
     *
     * @param forUseInAnIsa true is this is used in an ISA, false otherwise.
     * @param productType   the Product type to build.
     * @return the built Product.
     */
    public Product build(final boolean forUseInAnIsa, final ProductType productType) {
        final Product product = this.createProduct(productType);
        product.setIsTaxable(!forUseInAnIsa);
        return product;
    }

    /**
     * This is the 'Factory Method' that all concrete factory subclasses must implement to return the Product that they build.
     * <p>
     * Note that the method is protected and only visible to subclass factories.
     *
     * @param productType the type of product to build.
     * @return the built Product.
     */
    protected abstract Product createProduct(final ProductType productType);
}
