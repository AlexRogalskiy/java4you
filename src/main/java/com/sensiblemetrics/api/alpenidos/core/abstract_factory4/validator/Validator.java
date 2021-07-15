package com.sensiblemetrics.api.alpenidos.core.abstract_factory4.validator;

import com.sensiblemetrics.api.alpenidos.core.abstract_factory4.model.VirtualCoin;

@FunctionalInterface
public interface Validator {

    boolean isValid(VirtualCoin virtualCoin);
}
