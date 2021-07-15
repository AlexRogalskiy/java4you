package com.sensiblemetrics.api.alpenidos.core.abstract_factory4.validator;

import com.sensiblemetrics.api.alpenidos.core.abstract_factory4.model.VirtualCoin;

public class IntegerBitcoinValidator implements Validator {

    @Override
    public boolean isValid(VirtualCoin creditCard) {
        return true;
    }
}
