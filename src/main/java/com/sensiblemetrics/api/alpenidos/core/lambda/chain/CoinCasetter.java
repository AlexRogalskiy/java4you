package com.sensiblemetrics.api.alpenidos.core.lambda.chain;

class CoinCasetter {

    public final int sum;

    public CoinCasetter(int sum) {
        this.sum = sum;
    }

    CoinCasetter increment(int i) {
        return new CoinCasetter(sum + i);
    }
}
