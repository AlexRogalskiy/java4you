package com.sensiblemetrics.api.alpenidos.pattern.abstract_factory4.validator;

import com.sensiblemetrics.api.alpenidos.pattern.abstract_factory4.model.VirtualCoin;

@FunctionalInterface
public interface Validator {

    boolean isValid(VirtualCoin virtualCoin);
}
