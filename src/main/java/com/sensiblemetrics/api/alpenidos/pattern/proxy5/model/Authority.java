package com.sensiblemetrics.api.alpenidos.pattern.proxy5.model;

public class Authority {
    private static final String MAGIC_WORD = "please";
    private boolean saidMagicWord = false;

    public void authorize(String magicWord) {
        if (MAGIC_WORD.equals(magicWord)) {
            this.saidMagicWord = true;
        }
    }

    public boolean canProcessPayment() {
        return this.saidMagicWord;
    }
}
