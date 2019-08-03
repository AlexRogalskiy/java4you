package com.sensiblemetrics.api.alpenidos.core.chain2.enums;

/**
 * RequestType enumeration
 */
public enum RequestType {
    DEFEND_CASTLE,
    TORTURE_PRISONER,
    COLLECT_TAX;

    public boolean isDefendCastle() {
        return this.equals(DEFEND_CASTLE);
    }

    public boolean isTorturePrisoner() {
        return this.equals(TORTURE_PRISONER);
    }

    public boolean isCollectTax() {
        return this.equals(COLLECT_TAX);
    }
}
