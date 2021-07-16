package com.sensiblemetrics.api.alpenidos.core.lambda.chain;

public enum Coin {
    _1, _2, _5, ILLEGAL_COIN;

    public int value(int quantity) {
        switch (this) {
            case _1:
                return quantity;
            case _2:
                return 2 * quantity;
            case _5:
                return 5 * quantity;
            case ILLEGAL_COIN:
                return 0;
        }

        return quantity;
    }

//    public int value(int quantity) {
//        return switch (this) {
//            case _1 -> quantity;
//            case _2 -> 2 * quantity;
//            case _5 -> 5 * quantity;
//            case ILLEGAL_COIN -> 0;
//        };
//    }
}
