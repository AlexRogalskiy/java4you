package com.sensiblemetrics.api.alpenidos.pattern.abstract_factory4.factory;

import com.sensiblemetrics.api.alpenidos.pattern.abstract_factory4.enumeration.VirtualCoinType;
import com.sensiblemetrics.api.alpenidos.pattern.abstract_factory4.model.FractionedBitcoin;
import com.sensiblemetrics.api.alpenidos.pattern.abstract_factory4.model.IntegerBitcoin;
import com.sensiblemetrics.api.alpenidos.pattern.abstract_factory4.model.VirtualCoin;
import com.sensiblemetrics.api.alpenidos.pattern.abstract_factory4.validator.FractionedBitcoinValidator;
import com.sensiblemetrics.api.alpenidos.pattern.abstract_factory4.validator.IntegerBitcoinValidator;
import com.sensiblemetrics.api.alpenidos.pattern.abstract_factory4.validator.Validator;

public class BitcoinFactory extends VirtualCoinFactory {

    @Override
    public VirtualCoin getVirtualCoin(final VirtualCoinType virtualCoinType) {
        switch (virtualCoinType) {
            case FRACTIONED:
                return new FractionedBitcoin();
            case INTEGER:
                return new IntegerBitcoin();
            default:
                throw new IllegalArgumentException("Card type not found.");
        }
    }

    public Validator getValidator(final VirtualCoinType virtualCoinType) {
        switch (virtualCoinType) {
            case FRACTIONED:
                return new FractionedBitcoinValidator();
            case INTEGER:
                return new IntegerBitcoinValidator();
            default:
                throw new IllegalArgumentException("Card type not found.");
        }
    }
}
