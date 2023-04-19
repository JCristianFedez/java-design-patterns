package com.cristian.design.patterns.system;

import com.cristian.design.patterns.system.systemmaster.ArrayTransposeMaster;
import com.cristian.design.patterns.system.systemmaster.Master;

/**
 * Class ArrayTransposeMasterWorker extends abstract class {@link MasterWorker} and specifically solves the problem of finding transpose of
 * input array.
 */
public class ArrayTransposeMasterWorker extends MasterWorker<int[][]> {

  public ArrayTransposeMasterWorker() {
    super(4);
  }

  @Override
  public Master<int[][]> setMaster(int numOfWorkers) {
    return new ArrayTransposeMaster(numOfWorkers);
  }
}
