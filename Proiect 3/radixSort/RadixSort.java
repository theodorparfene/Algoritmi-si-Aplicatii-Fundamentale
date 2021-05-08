package radixSort;

import java.util.*;

public class RadixSort {

    public static void radixSort(List<Integer> unsortedArr, int maxZeroes) {
        ArrayDeque<Integer>[] queueArr = new ArrayDeque[10];
        int zeroes = 1;
        int number;
        for (int i = 0; i < 10; i++) {
            queueArr[i] = new ArrayDeque<>();
        }

        while (zeroes <= maxZeroes) {
            for (number = 0; number < unsortedArr.size(); number++) {
                int digit = getDigit(unsortedArr.get(number), zeroes);
                queueArr[digit].add(unsortedArr.get(number));
            }
            number = 0;

            for (int i = 0; i < 10; i++) {
                while (!queueArr[i].isEmpty()) {
                    System.out.println(queueArr[i]);
                    unsortedArr.set(number, queueArr[i].remove());
                    number++;
                }
            }
            zeroes *= 10;
        }
    }

    public static int getDigit(int number, int zeroes) {
        return (number/zeroes) % 10;
    }

    public static void addElements(List<Integer> unsortedArr) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            unsortedArr.add(sc.nextInt());
        }

        sc.close();
    }

    public static void printList(List<Integer> unsortedArr) {
        for (int e : unsortedArr) {
            System.out.print(e + " ");
        }
    }

    public static void descendingRadixSort(List<Integer> unsortedArr, int maxZeroes) {
        ArrayDeque<Integer>[] queueArr = new ArrayDeque[10];
        int zeroes = 1;
        int number;
        for (int i = 0; i < 10; i++) {
            queueArr[i] = new ArrayDeque<>();
        }

        while (zeroes <= maxZeroes) {
            for (number = 0; number < unsortedArr.size(); number++) {
                int digit = switchGetDigit(getDigit(unsortedArr.get(number), zeroes));
                queueArr[digit].add(unsortedArr.get(number));
            }
            number = 0;

            for (int i = 0; i < 10; i++) {
                while (!queueArr[i].isEmpty()) {
                    System.out.println(queueArr[i]);
                    unsortedArr.set(number, queueArr[i].remove());
                    number++;
                }
            }
            zeroes *= 10;
        }
    }

    public static int switchGetDigit(int digit) { // Scuze, nu mai gaseam alta solutie.. :(
        switch (digit) {
            case 0:
                return 9;
            case 1:
                return 8;
            case 2:
                return 7;
            case 3:
                return 6;
            case 4:
                return 5;
            case 5:
                return 4;
            case 6:
                return 3;
            case 7:
                return 2;
            case 8:
                return 1;
            case 9:
                return 0;
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> unsortedArr = new ArrayList<>();
        addElements(unsortedArr);
        printList(unsortedArr);
        System.out.println();
        radixSort(unsortedArr, 1000);
        printList(unsortedArr);
        System.out.println();
        descendingRadixSort(unsortedArr, 1000);
        printList(unsortedArr);

    }
}
