package com.sensiblemetrics.api.alpenidos.pattern.abstract_factory4.factory;

import com.sensiblemetrics.api.alpenidos.pattern.abstract_factory4.enumeration.VirtualCoinType;
import com.sensiblemetrics.api.alpenidos.pattern.abstract_factory4.model.VirtualCoin;
import com.sensiblemetrics.api.alpenidos.pattern.abstract_factory4.validator.Validator;

public abstract class VirtualCoinFactory {

    public static double BIT_COIN_VALUE = 2000;

    public static VirtualCoinFactory getVirtualCoinFactory(final double moneyToInvest) {
        if (moneyToInvest >= BIT_COIN_VALUE) {
            return new BitcoinFactory();
        }
        return new EtheriumFactory();
    }

    public abstract VirtualCoin getVirtualCoin(VirtualCoinType virtualCoinType);

    public abstract Validator getValidator(VirtualCoinType virtualCoinType);
}
