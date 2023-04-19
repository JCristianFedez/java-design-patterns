package com.cristian.design.patterns;

import java.security.SecureRandom;

import lombok.extern.slf4j.Slf4j;

/**
 * Class ArrayUtilityMethods has some utility methods for matrices and arrays.
 */
@Slf4j
public class ArrayUtilityMethods {

  private static final SecureRandom RANDOM = new SecureRandom();

  private ArrayUtilityMethods() {
  }

  /**
   * Method arraysSame compares 2 arrays @param a1 and @param a2 and @return whether their values are equal (boolean).
   */
  public static boolean arraysSame(int[] a1, int[] a2) {
    //compares if 2 arrays have the same value
    if (a1.length != a2.length) {
      return false;
    } else {
      var answer = false;
      for (var i = 0; i < a1.length; i++) {
        if (a1[i] == a2[i]) {
          answer = true;
        } else {
          answer = false;
          break;
        }
      }
      return answer;
    }
  }

  /**
   * Method createRandomIntMatrix creates a random matrix of size @param rows and @param columns.
   *
   * @return it (int[][]).
   */
  public static int[][] createRandomIntMatrix(int rows, int columns) {
    final int[][] matrix = new int[rows][columns];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        //filling cells in matrix
        matrix[i][j] = RANDOM.nextInt(10);
      }
    }
    return matrix;
  }

  /**
   * Method printMatrix prints input matrix @param matrix.
   */
  public static void printMatrix(int[][] matrix) {
    //prints out int[][]
    for (int[] ints : matrix) {
      for (int j = 0; j < matrix[0].length; j++) {
        LOGGER.info(ints[j] + " ");
      }
      LOGGER.info("");
    }
  }

}
