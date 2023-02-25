package com.cristian.design.patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Class ArrayInput extends abstract class {@link Input} and contains data of type int[][].
 */
public class ArrayInput extends Input<int[][]> {

  public ArrayInput(int[][] data) {
    super(data);
  }

  private int[] makeDivisions(int[][] data, int num) {
    final int initialDivision = data.length / num;//equally dividing
    final int[] divisions = new int[num];
    Arrays.fill(divisions, initialDivision);
    if (initialDivision * num != data.length) {
      int extra = data.length - initialDivision * num;
      int l = 0;
      //equally dividing extra among all parts
      while (extra > 0) {
        divisions[l] = divisions[l] + 1;
        extra--;
        if (l == num - 1) {
          l = 0;
        } else {
          l++;
        }
      }
    }
    return divisions;
  }

  @Override
  public List<Input<int[][]>> divideData(int num) {
    if (this.data == null) {
      return Collections.emptyList();
    } else {
      final int[] divisions = makeDivisions(this.data, num);
      final ArrayList<Input<int[][]>> result = new ArrayList<>(num);
      int rowsDone = 0; //number of rows divided so far
      for (int i = 0; i < num; i++) {
        final int rows = divisions[i];
        if (rows != 0) {
          final int[][] divided = new int[rows][this.data[0].length];
          System.arraycopy(this.data, rowsDone, divided, 0, rows);
          rowsDone += rows;
          final ArrayInput dividedInput = new ArrayInput(divided);
          result.add(dividedInput);
        } else {
          break; //rest of divisions will also be 0
        }
      }
      return result;
    }
  }
}
