package com.sensiblemetrics.api.alpenidos.pattern.map_reduce.master;

import com.sensiblemetrics.api.alpenidos.pattern.map_reduce.model.Input;
import com.sensiblemetrics.api.alpenidos.pattern.map_reduce.model.Result;
import com.sensiblemetrics.api.alpenidos.pattern.map_reduce.worker.Worker;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * The abstract Master class which contains private fields numOfWorkers
 * (number of workers), workers (arraylist of workers), expectedNumResults
 * (number of divisions of input data, same as expected number of results),
 * allResultData (hashtable of results obtained from workers, mapped by
 * their ids) and finalResult (aggregated from allResultData).
 */
public abstract class Master {
    private final int numOfWorkers;
    private final ArrayList<Worker> workers;
    private int expectedNumResults;
    private Hashtable<Integer, Result> allResultData;
    private Result finalResult;

    public Master(final int numOfWorkers) {
        this.numOfWorkers = numOfWorkers;
        this.workers = setWorkers(numOfWorkers);
        this.expectedNumResults = 0;
        this.allResultData = new Hashtable<Integer, Result>(numOfWorkers);
        this.finalResult = null;
    }

    public Result getFinalResult() {
        return this.finalResult;
    }

    Hashtable<Integer, Result> getAllResultData() {
        return this.allResultData;
    }

    int getExpectedNumResults() {
        return this.expectedNumResults;
    }

    ArrayList<Worker> getWorkers() {
        return this.workers;
    }

    public void doWork(final Input input) {
        this.divideWork(input);
    }

    private void divideWork(final Input input) {
        final List<Input> dividedInput = input.divideData(numOfWorkers);
        if (dividedInput != null) {
            this.expectedNumResults = dividedInput.size();
            for (int i = 0; i < this.expectedNumResults; i++) {
                //ith division given to ith worker in this.workers
                this.workers.get(i).setReceivedData(this, dividedInput.get(i));
                this.workers.get(i).run();
            }
        }
    }

    public void receiveData(final Result data, final Worker w) {
        //check if can receive..if yes:
        this.collectResult(data, w.getWorkerId());
    }

    private void collectResult(final Result data, final int workerId) {
        this.allResultData.put(workerId, data);
        if (this.allResultData.size() == this.expectedNumResults) {
            //all data received
            this.finalResult = this.aggregateData();
        }
    }

    protected abstract ArrayList<Worker> setWorkers(int num);

    protected abstract Result aggregateData();
}
