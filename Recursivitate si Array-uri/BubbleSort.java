public class BubbleSort {
    private static void bubbleSort(int[] array) {
        int aux = 0;
        boolean swapped;
        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                //pentru sortare descrescatoare se poate modifica conditia de mai jos in array[j] < array[j + 1]
                if (array[j] > array[j + 1]) {
                    aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = {22, 41, 0, 3, 13, 5, 81};
        bubbleSort(array);
        System.out.println("Sorted array: ");
        printArray(array);
    }
}