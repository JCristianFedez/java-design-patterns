package com.cristian.design.patterns.system;

import com.cristian.design.patterns.Input;
import com.cristian.design.patterns.Result;
import com.cristian.design.patterns.system.systemmaster.Master;

/**
 * The abstract MasterWorker class which contains reference to master.
 */
public abstract class MasterWorker<E> {

  private final Master<E> master;

  protected MasterWorker(int numOfWorkers) {
    this.master = setMaster(numOfWorkers);
  }

  public abstract Master<E> setMaster(int numOfWorkers);

  public Result<E> getResult(Input<E> input) {
    this.master.doWork(input);
    return this.master.getFinalResult();
  }
}

