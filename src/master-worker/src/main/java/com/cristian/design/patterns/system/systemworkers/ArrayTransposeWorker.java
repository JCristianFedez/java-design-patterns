package com.cristian.design.patterns.system.systemworkers;

import com.cristian.design.patterns.ArrayResult;
import com.cristian.design.patterns.Input;
import com.cristian.design.patterns.system.systemmaster.Master;

/**
 * Class ArrayTransposeWorker extends abstract class {@link Worker} and defines method executeOperation(), to be performed on data received
 * from master.
 */
public class ArrayTransposeWorker extends Worker<int[][]> {

  public ArrayTransposeWorker(Master<int[][]> master, int id) {
    super(master, id);
  }

  @Override
  public ArrayResult executeOperation() {
    //number of rows in result matrix is equal to number of columns in input matrix and vice versa
    final Input<int[][]> arrayInput = this.getReceivedData();
    final int rows = arrayInput.getData()[0].length;
    final int cols = arrayInput.getData().length;
    final int[][] resultData = new int[rows][cols];
    for (int i = 0; i < cols; i++) {
      for (int j = 0; j < rows; j++) {
        //flipping element positions along diagonal
        resultData[j][i] = arrayInput.getData()[i][j];
      }
    }
    return new ArrayResult(resultData);
  }
}
