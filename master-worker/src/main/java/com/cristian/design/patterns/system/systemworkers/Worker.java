package com.cristian.design.patterns.system.systemworkers;

import com.cristian.design.patterns.Input;
import com.cristian.design.patterns.Result;
import com.cristian.design.patterns.system.systemmaster.Master;

/**
 * The abstract Worker class which extends Thread class to enable parallel processing. Contains fields master(holding reference to master),
 * workerId (unique id) and receivedData(from master).
 */
public abstract class Worker<E> extends Thread {

  private final Master<E> master;

  private final int workerId;

  private Input<E> receivedData;

  protected Worker(Master<E> master, int id) {
    this.master = master;
    this.workerId = id;
    this.receivedData = null;
  }

  public int getWorkerId() {
    return this.workerId;
  }

  public Input<E> getReceivedData() {
    return this.receivedData;
  }

  public void setReceivedData(Master<E> m, Input<E> i) {
    //check if ready to receive..if yes:
    this.receivedData = i;
  }

  public abstract Result<E> executeOperation();

  private void sendToMaster(Result<E> data) {
    this.master.receiveData(data, this);
  }

  public void run() { //from Thread class
    final Result<E> work = executeOperation();
    sendToMaster(work);
  }
}
