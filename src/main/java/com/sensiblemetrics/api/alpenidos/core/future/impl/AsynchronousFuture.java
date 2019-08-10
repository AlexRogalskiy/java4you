package com.sensiblemetrics.api.alpenidos.core.future.impl;

/**
 * Based on: "Patterns in Java", Mark Grand.
 * <p>
 * Date: Aug 22, 2011
 *
 * @author moleksyuk
 */
public class AsynchronousFuture {
    private Object result;
    private boolean resultIsSet;
    private Exception problem;

    public boolean checkResult() {
        return this.resultIsSet;
    }

    public synchronized Object getResult() throws Exception {
        while (!this.resultIsSet) {
            this.wait();
        }
        if (this.problem != null) {
            throw this.problem;
        }
        return this.result;
    }

    public synchronized void setResult(final Object result) {
        if (this.resultIsSet) {
            throw new IllegalArgumentException("Result is already set");
        }
        this.result = result;
        this.resultIsSet = true;
        this.notifyAll();
    }

    public synchronized void setException(final Exception e) {
        this.problem = e;
        this.resultIsSet = true;
        this.notifyAll();
    }
}
