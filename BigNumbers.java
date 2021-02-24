import java.util.ArrayList;
import java.util.Arrays;

public class BigNumbers {

    public String convertArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int value : arr) {
            sb.append(value);
        }
        return sb.toString();
    }

    public int[] sum(int[] op1, int[] op2) {

        String first = convertArray(op1);
        String second = convertArray(op2);
        int result = Integer.parseInt(first) + Integer.parseInt(second);

        if (result == 0) {
            return new int[0];
        }

        ArrayList<Integer> digits = new ArrayList<Integer>();

        while (result != 0) {
            digits.add(result % 10);
            result /= 10;
        }

        Integer[] array = digits.toArray(new Integer[0]);

        int temp = 0;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return Arrays.stream(array).mapToInt(Integer::intValue).toArray();
    }

        public static void main(String[] args) {
            System.out.println("Checking input...");

            int[] op1 = {2, 1, 7, 8};
            int[] op2 = {5, 9, 6};

            BigNumbers bn = new BigNumbers();
            int[] rez = bn.sum(op1, op2);
            int[] correct = {2, 7, 7, 4};
            System.out.println(noToString(op1) + " + " + noToString(op2) +
                    " = " + noToString(rez) + " C: " + noToString(correct));
        }

        private static String noToString(int[] no) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < no.length; i++) {
                sb.append(no[i]);
            }
            return sb.toString();
        }
    }
