package com.sensiblemetrics.api.alpenidos.core.cor2.handler;

import com.sensiblemetrics.api.alpenidos.core.cor2.impl.Command;
import lombok.Data;

@Data
public abstract class PurchasePower {
    public static final int BASE = 10;

    private PurchasePower successor;

    public abstract void handleRequest(final Command command);
}
