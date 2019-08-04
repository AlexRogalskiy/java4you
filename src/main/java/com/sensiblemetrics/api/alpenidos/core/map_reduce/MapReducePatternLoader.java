package com.sensiblemetrics.api.alpenidos.core.map_reduce;

import com.sensiblemetrics.api.alpenidos.core.map_reduce.master.ArrayTransposeMaster;
import com.sensiblemetrics.api.alpenidos.core.map_reduce.master.Master;
import com.sensiblemetrics.api.alpenidos.core.map_reduce.master_worker.ArrayTransposeMasterWorker;
import com.sensiblemetrics.api.alpenidos.core.map_reduce.master_worker.MasterWorker;
import com.sensiblemetrics.api.alpenidos.core.map_reduce.model.ArrayInput;
import com.sensiblemetrics.api.alpenidos.core.map_reduce.model.ArrayResult;
import com.sensiblemetrics.api.alpenidos.core.map_reduce.model.Input;
import com.sensiblemetrics.api.alpenidos.core.map_reduce.model.Result;
import com.sensiblemetrics.api.alpenidos.core.map_reduce.utils.ArrayUtilityMethods;
import com.sensiblemetrics.api.alpenidos.core.map_reduce.worker.ArrayTransposeWorker;
import com.sensiblemetrics.api.alpenidos.core.map_reduce.worker.Worker;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>The <b><em>Master-Worker</em></b> pattern is used when the problem at hand can be solved by dividing into
 * multiple parts which need to go through the same computation and may need to be aggregated to get final result.
 * Parallel processing is performed using a system consisting of a master and some number of workers, where a
 * master divides the work among the workers, gets the result back from them and assimilates all the results to
 * give final result. The only communication is between the master and the worker - none of the workers communicate
 * among one another and the user only communicates with the master to get required job done.</p>
 * <p>In our example, we have generic abstract classes {@link MasterWorker}, {@link Master} and {@link Worker} which
 * have to be extended by the classes which will perform the specific job at hand (in this case finding transpose of
 * matrix, done by {@link ArrayTransposeMasterWorker}, {@link ArrayTransposeMaster} and {@link ArrayTransposeWorker}).
 * The Master class divides the work into parts to be given to the workers, collects the results from the workers and
 * aggregates it when all workers have responded before returning the solution. The Worker class extends the Thread
 * class to enable parallel processing, and does the work once the data has been received from the Master. The
 * MasterWorker contains a reference to the Master class, gets the input from the MapReducePatternLoader and passes it on to the Master.
 * These 3 classes define the system which computes the result. We also have 2 abstract classes {@link Input} and
 * {@link Result}, which contain the input data and result data respectively. The Input class also has an abstract
 * method divideData which defines how the data is to be divided into segments. These classes are extended by
 * {@link ArrayInput} and {@link ArrayResult}.</p>
 */
@Slf4j
public class MapReducePatternLoader {

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        final ArrayTransposeMasterWorker worker = new ArrayTransposeMasterWorker();
        int rows = 10;
        int columns = 20;
        final int[][] inputMatrix = ArrayUtilityMethods.createRandomIntMatrix(rows, columns);
        final ArrayInput input = new ArrayInput(inputMatrix);
        final ArrayResult result = (ArrayResult) worker.getResult(input);

        if (result != null) {
            ArrayUtilityMethods.printMatrix(inputMatrix);
            log.debug("------------------------------------------");
            ArrayUtilityMethods.printMatrix(result.data);
        } else {
            log.debug("Please enter non-zero input");
        }
    }
}
