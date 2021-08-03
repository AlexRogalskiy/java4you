package com.sensiblemetrics.api.alpenidos.pattern.map_reduce.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * Class ArrayUtilityMethods has some utility methods for matrices and arrays.
 */
@Slf4j
@UtilityClass
public class ArrayUtilityMethods {

    /**
     * Method arraysSame compares 2 arrays @param a1 and @param a2
     * and @return whether their values are equal (boolean).
     */
    public static boolean arraysSame(final int[] a1, final int[] a2) {
        //compares if 2 arrays have the same value
        if (a1.length != a2.length) {
            return false;
        } else {
            boolean answer = false;
            for (int i = 0; i < a1.length; i++) {
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
     * Method matricesSame compares 2 matrices @param m1 and @param m2
     * and @return whether their values are equal (boolean).
     */
    public static boolean matricesSame(final int[][] m1, final int[][] m2) {
        if (m1.length != m2.length) {
            return false;
        } else {
            boolean answer = false;
            for (int i = 0; i < m1.length; i++) {
                if (arraysSame(m1[i], m2[i])) {
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
     * Method createRandomIntMatrix creates a random matrix of size @param rows
     * and @param columns @return it (int[][]).
     */
    public static int[][] createRandomIntMatrix(final int rows, final int columns) {
        int[][] matrix = new int[rows][columns];
        final Random rand = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                //filling cells in matrix
                matrix[i][j] = rand.nextInt(10);
            }
        }
        return matrix;
    }

    /**
     * Method printMatrix prints input matrix @param matrix.
     */
    public static void printMatrix(final int[][] matrix) {
        //prints out int[][]
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                log.debug(matrix[i][j] + " ");
            }
            log.debug("");
        }
    }
}
