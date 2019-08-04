package com.sensiblemetrics.api.alpenidos.core.map_reduce.worker;

import com.sensiblemetrics.api.alpenidos.core.map_reduce.model.ArrayInput;
import com.sensiblemetrics.api.alpenidos.core.map_reduce.model.ArrayResult;
import com.sensiblemetrics.api.alpenidos.core.map_reduce.master.Master;

/**
 * Class ArrayTransposeWorker extends abstract class {@link Worker} and defines method
 * executeOperation(), to be performed on data received from master.
 */

public class ArrayTransposeWorker extends Worker {

    public ArrayTransposeWorker(Master master, int id) {
        super(master, id);
    }

    @Override
    public ArrayResult executeOperation() {
        //number of rows in result matrix is equal to number of columns in input matrix and vice versa
        final int[][] resultData = new int[((ArrayInput) this.getReceivedData()).data[0].length][((ArrayInput) this.getReceivedData()).data.length];
        for (int i = 0; i < ((ArrayInput) this.getReceivedData()).data.length; i++) {
            for (int j = 0; j < ((ArrayInput) this.getReceivedData()).data[0].length; j++) {
                //flipping element positions along diagonal
                resultData[j][i] = ((ArrayInput) this.getReceivedData()).data[i][j];
            }
        }
        return new ArrayResult(resultData);
    }
}
