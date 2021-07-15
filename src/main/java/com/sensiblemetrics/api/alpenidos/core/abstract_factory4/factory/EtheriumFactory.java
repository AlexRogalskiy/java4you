package com.sensiblemetrics.api.alpenidos.core.abstract_factory4.factory;

import com.sensiblemetrics.api.alpenidos.core.abstract_factory4.enumeration.VirtualCoinType;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory4.model.FractionedEtherium;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory4.model.IntegerEtherium;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory4.model.VirtualCoin;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory4.validator.EtheriumValidator;
import com.sensiblemetrics.api.alpenidos.core.abstract_factory4.validator.Validator;

public class EtheriumFactory extends VirtualCoinFactory {

    @Override
    public VirtualCoin getVirtualCoin(final VirtualCoinType virtualCoinType) {
        switch (virtualCoinType) {
            case FRACTIONED:
                return new FractionedEtherium();
            case INTEGER:
                return new IntegerEtherium();
        }

        throw new IllegalArgumentException(virtualCoinType + " not found");
    }

    @Override
    public Validator getValidator(final VirtualCoinType virtualCoinType) {
        return new EtheriumValidator();
    }
}
