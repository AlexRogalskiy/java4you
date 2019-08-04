package com.sensiblemetrics.api.alpenidos.core.map_reduce.master_worker;

import com.sensiblemetrics.api.alpenidos.core.map_reduce.model.Input;
import com.sensiblemetrics.api.alpenidos.core.map_reduce.model.Result;
import com.sensiblemetrics.api.alpenidos.core.map_reduce.master.Master;

/**
 * The abstract MasterWorker class which contains reference to master.
 */
public abstract class MasterWorker {
    private final Master master;

    public MasterWorker(int numOfWorkers) {
        this.master = this.setMaster(numOfWorkers);
    }

    protected abstract Master setMaster(int numOfWorkers);

    public Result getResult(final Input input) {
        this.master.doWork(input);
        return this.master.getFinalResult();
    }
}
