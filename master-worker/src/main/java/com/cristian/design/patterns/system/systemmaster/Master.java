package com.cristian.design.patterns.system.systemmaster;

import java.util.Hashtable;
import java.util.List;

import com.cristian.design.patterns.Input;
import com.cristian.design.patterns.Result;
import com.cristian.design.patterns.system.systemworkers.Worker;

import lombok.extern.slf4j.Slf4j;

/**
 * The abstract Master class which contains private fields numOfWorkers (number of workers), workers (arraylist of workers),
 * expectedNumResults (number of divisions of input data, same as expected number of results), allResultData (hashtable of results obtained
 * from workers, mapped by their ids) and finalResult (aggregated from allResultData).
 */
@Slf4j
public abstract class Master<E> {

  private final int numOfWorkers;

  private final List<Worker<E>> workers;

  private final Hashtable<Integer, Result<E>> allResultData;

  private int expectedNumResults;

  private Result<E> finalResult;

  protected Master(int numOfWorkers) {
    this.numOfWorkers = numOfWorkers;
    this.workers = setWorkers(numOfWorkers);
    this.expectedNumResults = 0;
    this.allResultData = new Hashtable<>(numOfWorkers);
    this.finalResult = null;
  }

  public Result<E> getFinalResult() {
    return this.finalResult;
  }

  public Hashtable<Integer, Result<E>> getAllResultData() {
    return this.allResultData;
  }

  public int getExpectedNumResults() {
    return this.expectedNumResults;
  }

  public List<Worker<E>> getWorkers() {
    return this.workers;
  }

  public abstract List<Worker<E>> setWorkers(int num);

  public void doWork(Input<E> input) {
    divideWork(input);
  }

  private void divideWork(Input<E> input) {
    final List<Input<E>> dividedInput = input.divideData(this.numOfWorkers);
    if (dividedInput != null) {
      this.expectedNumResults = dividedInput.size();
      for (int i = 0; i < this.expectedNumResults; i++) {
        //ith division given to ith worker in this.workers
        this.workers.get(i).setReceivedData(this, dividedInput.get(i));
        this.workers.get(i).start();
      }
      for (int i = 0; i < this.expectedNumResults; i++) {
        try {
          this.workers.get(i).join();
        } catch (InterruptedException e) {
          LOGGER.error("Error while executing thread");
          Thread.currentThread().interrupt();
        }
      }
    }
  }

  public void receiveData(Result<E> data, Worker<E> w) {
    //check if can receive..if yes:
    collectResult(data, w.getWorkerId());
  }

  private void collectResult(Result<E> data, int workerId) {
    this.allResultData.put(workerId, data);
    if (this.allResultData.size() == this.expectedNumResults) {
      //all data received
      this.finalResult = aggregateData();
    }
  }

  public abstract Result<E> aggregateData();
}
