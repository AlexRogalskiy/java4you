package com.sensiblemetrics.api.alpenidos.pattern.map_reduce.master;

import com.sensiblemetrics.api.alpenidos.pattern.map_reduce.model.ArrayResult;
import com.sensiblemetrics.api.alpenidos.pattern.map_reduce.worker.Worker;
import com.sensiblemetrics.api.alpenidos.pattern.map_reduce.worker.ArrayTransposeWorker;

import java.util.ArrayList;
import java.util.Enumeration;

/**
 * Class ArrayTransposeMaster extends abstract class {@link Master} and contains
 * definition of aggregateData, which will obtain final result from all
 * data obtained and for setWorkers.
 */

public class ArrayTransposeMaster extends Master {

    public ArrayTransposeMaster(final int numOfWorkers) {
        super(numOfWorkers);
    }

    @Override
    public ArrayList<Worker> setWorkers(final int num) {
        ArrayList<Worker> ws = new ArrayList<Worker>(num);
        for (int i = 0; i < num; i++) {
            ws.add(new ArrayTransposeWorker(this, i + 1));
            //i+1 will be id
        }
        return ws;
    }

    @Override
    public ArrayResult aggregateData() {
        //number of rows in final result is number of rows in any of obtained results obtained from workers
        final int rows = ((ArrayResult) this.getAllResultData().get(this.getAllResultData().keys().nextElement())).data.length;
        int columns = 0; //number of columns is sum of number of columns in all results obtained from workers
        for (Enumeration<Integer> e = this.getAllResultData().keys(); e.hasMoreElements(); ) {
            columns += ((ArrayResult) this.getAllResultData().get(e.nextElement())).data[0].length;
        }
        int[][] resultData = new int[rows][columns];
        int columnsDone = 0; //columns aggregated so far
        for (int i = 0; i < this.getExpectedNumResults(); i++) {
            //result obtained from ith worker
            final int[][] work = ((ArrayResult) this.getAllResultData().get(this.getWorkers().get(i).getWorkerId())).data;
            for (int m = 0; m < work.length; m++) {
                //m = row number, n = columns number
                for (int n = 0; n < work[0].length; n++) {
                    resultData[m][columnsDone + n] = work[m][n];
                }
            }
            columnsDone += work[0].length;
        }
        return new ArrayResult(resultData);
    }
}
