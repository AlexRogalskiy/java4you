package com.sensiblemetrics.api.alpenidos.pattern.cor2.impl;

import lombok.Data;

@Data
public class Command {
    private int amount;

    public Command(final int amount) {
        this.amount = amount;
    }
}
