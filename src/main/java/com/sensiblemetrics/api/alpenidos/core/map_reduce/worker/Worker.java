package com.sensiblemetrics.api.alpenidos.core.map_reduce.worker;

import com.sensiblemetrics.api.alpenidos.core.map_reduce.model.Input;
import com.sensiblemetrics.api.alpenidos.core.map_reduce.model.Result;
import com.sensiblemetrics.api.alpenidos.core.map_reduce.master.Master;
import lombok.RequiredArgsConstructor;

/**
 * The abstract Worker class which extends Thread class to enable parallel
 * processing. Contains fields master(holding reference to master), workerId
 * (unique id) and receivedData(from master).
 */
@RequiredArgsConstructor
public abstract class Worker extends Thread {
    private final Master master;
    private final int workerId;
    private Input receivedData;

    public int getWorkerId() {
        return this.workerId;
    }

    public Input getReceivedData() {
        return this.receivedData;
    }

    public void setReceivedData(final Master m, final Input input) {
        this.receivedData = input;
    }

    protected abstract Result executeOperation();

    private void sendToMaster(final Result data) {
        this.master.receiveData(data, this);
    }

    public void run() {
        final Result work = this.executeOperation();
        this.sendToMaster(work);
    }
}
