package com.sensiblemetrics.api.alpenidos.pattern.abstract_factory4.validator;

import com.sensiblemetrics.api.alpenidos.pattern.abstract_factory4.model.VirtualCoin;

public class EtheriumValidator implements Validator {

    @Override
    public boolean isValid(VirtualCoin virtualCoin) {
        return false;
    }
}
