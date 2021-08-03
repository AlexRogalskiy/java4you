package com.sensiblemetrics.api.alpenidos.pattern.cor.model;

public abstract class Leader {
    protected String name;
    protected Leader successor;

    public Leader(final String name) {
        this.name = name;
    }

    public void setSuccessor(final Leader successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(final LeaveRequest request);
}
