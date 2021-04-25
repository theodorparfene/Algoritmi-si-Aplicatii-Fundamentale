package LinkedList;

import java.util.Arrays;

public class BigNumbers {

    public int[] sum(int[] op1, int[] op2) {
        int[] sum = new int[Math.max(op1.length, op2.length)];
        reverse(op1);
        reverse(op2);
        int result = 0;
        for (int i = 0; i < sum.length; i++) {

            if (i > op1.length - 1) {
                result += op2[i];
            } else if (i > op2.length - 1) {
                result += op1[i];
            } else {
                result += op1[i] + op2[i];
            }

            if (result > 9) {
                sum[i] = result % 10;
                result /= 10;
            } else {
                sum[i] = result;
                result = 0;
            }

            if (i == sum.length - 1) {
                if (result == 0) {
                    break;
                } else {
                    sum = Arrays.copyOf(sum, sum.length + 1);
                    sum[i + 1] = result;
                    break;
                }

            }
        }
        reverse(op1);
        reverse(op2);
        reverse(sum);
        return sum;
    }

    public void reverse(int[] array) {
        int temp = 0;
        int n = array.length;

        for (int i = 0; i < n / 2; i++) {
            temp = array[n - i - 1];
            array[n - i - 1] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        int noTests = 6;

        int[][] op1 = {{0}, {9, 9}, {9}, {2, 1, 7, 8},
                {5, 0, 5, 0, 5}, {1, 0, 8, 6, 7, 8, 9, 4, 2, 3, 4}};
        int[][] op2 = {{1, 0, 1}, {1}, {9, 9, 9, 9}, {5, 9, 6},
                {5, 5, 0, 5, 0}, {3, 4, 2, 8, 9, 7, 9, 2, 3, 4, 9}};
        int[][] correct = {{1, 0, 1}, {1, 0, 0}, {1, 0, 0, 0, 8}, {2, 7, 7, 4},
                {1, 0, 5, 5, 5, 5}, {4, 5, 1, 5, 7, 6, 8, 6, 5, 8, 3}};

        int total = 0;
        for (int i = 0; i < noTests; i++) {
            System.out.println("Test " + (i+1) + ":");
            String op1S = noToString(op1[i]);
            String op2S = noToString(op2[i]);

            BigNumbers bn = new BigNumbers();
            int[] rez = bn.sum(op1[i], op2[i]);

            String rezS = noToString(rez);
            String correctS = noToString(correct[i]);
            System.out.println(op1S + " + " + op2S + " = " + rezS + " C: " + correctS +
                    "......" + (rezS.equals(correctS) ? "OK" : "WRONG"));
            System.out.println();

            total += rezS.equals(correctS) ? 1 : 0;
        }

        System.out.println("Your total score is: " + total + " / " + noTests);
        System.out.println(total > 3 ? "You passed! Hurray! :)" : "Sorry.. :(");
    }

    private static String noToString(int[] no) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < no.length; i++) {
            sb.append(no[i]);
        }
        return sb.toString();
    }
}