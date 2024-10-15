/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DemoTest;

/**
 * @author umarsaeed
 */
public class Equilibrium {

  // O(n) space, O(n) time
  public static int equi(int[] A) {

    if (A != null) {

      long[] leftSum = new long[A.length];
      long[] rightSum = new long[A.length];

      long sum = 0;
      for (int i = 0; i < A.length; i++) {
        sum += A[i];
        leftSum[i] = sum;
      }

      sum = 0;
      for (int i = A.length - 1; i >= 0; i--) {
        sum += A[i];
        rightSum[i] = sum;
      }

      for (int i = 0; i < A.length; i++) {
        if (i > 0 && i < A.length - 1 && leftSum[i - 1] == rightSum[i + 1]) {
          return i;
        }
        if (leftSum[i] == rightSum[i]) {
          return i;
        }
      }
    }
    return -1;
  }

  public static void main(String Args[]) {

    // Test cases
    int[] test0 = {};
    System.out.println(equi(test0));

    int[] test1 = {-100000};
    System.out.println(equi(test1));

    int[] test2 = {0, 0, 0, 0, 0, -100000};
    System.out.println(equi(test2));

    int[] test3 = {-100000, 0, 0, 0, 0, 0};
    System.out.println(equi(test3));

    int[] test4 = {100, -20, 0, -20, 100};
    System.out.println(equi(test4));
  }
}
