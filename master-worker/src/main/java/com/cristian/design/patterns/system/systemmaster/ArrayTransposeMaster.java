package com.cristian.design.patterns.system.systemmaster;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.cristian.design.patterns.ArrayResult;
import com.cristian.design.patterns.Result;
import com.cristian.design.patterns.system.systemworkers.ArrayTransposeWorker;
import com.cristian.design.patterns.system.systemworkers.Worker;

/**
 * Class ArrayTransposeMaster extends abstract class {@link Master} and contains definition of aggregateData, which will obtain final result
 * from all data obtained and for setWorkers.
 */
public class ArrayTransposeMaster extends Master<int[][]> {

  public ArrayTransposeMaster(int numOfWorkers) {
    super(numOfWorkers);
  }

  @Override
  public List<Worker<int[][]>> setWorkers(int num) {
    //i+1 will be id
    return IntStream.range(0, num)
        .mapToObj(i -> new ArrayTransposeWorker(this, i + 1))
        .collect(Collectors.toCollection(() -> new ArrayList<>(num)));
  }

  @Override
  public ArrayResult aggregateData() {
    // number of rows in final result is number of rows in any of obtained results from workers
    final Hashtable<Integer, Result<int[][]>> allResultData = this.getAllResultData();
    final int rows = allResultData.elements().nextElement().getData().length;
    final Enumeration<Result<int[][]>> elements = allResultData.elements();
    int columns = 0; // columns = sum of number of columns in all results obtained from workers
    while (elements.hasMoreElements()) {
      columns += elements.nextElement().getData()[0].length;
    }
    final int[][] resultData = new int[rows][columns];
    int columnsDone = 0; //columns aggregated so far
    final List<Worker<int[][]>> workers = this.getWorkers();
    for (int i = 0; i < this.getExpectedNumResults(); i++) {
      //result obtained from ith worker
      final Worker<int[][]> worker = workers.get(i);
      final int workerId = worker.getWorkerId();
      final int[][] work = allResultData.get(workerId).getData();
      for (int m = 0; m < work.length; m++) {
        //m = row number, n = columns number
        System.arraycopy(work[m], 0, resultData[m], columnsDone, work[0].length);
      }
      columnsDone += work[0].length;
    }
    return new ArrayResult(resultData);
  }

}
