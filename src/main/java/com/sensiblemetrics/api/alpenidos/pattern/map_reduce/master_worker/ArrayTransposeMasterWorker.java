package com.sensiblemetrics.api.alpenidos.pattern.map_reduce.master_worker;

import com.sensiblemetrics.api.alpenidos.pattern.map_reduce.master.ArrayTransposeMaster;
import com.sensiblemetrics.api.alpenidos.pattern.map_reduce.master.Master;

/**
 * Class ArrayTransposeMasterWorker extends abstract class {@link MasterWorker} and
 * specifically solves the problem of finding transpose of input array.
 */

public class ArrayTransposeMasterWorker extends MasterWorker {

    public ArrayTransposeMasterWorker() {
        super(4);
    }

    @Override
    public Master setMaster(final int numOfWorkers) {
        return new ArrayTransposeMaster(numOfWorkers);
    }
}
