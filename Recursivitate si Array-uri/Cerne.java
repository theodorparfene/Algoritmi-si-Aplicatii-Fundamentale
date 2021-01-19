public class Cerne {
    private static void moveNullElements(int[] array) {
        int aux = array.length -1;
        for (int i = array.length - 1; i >= 0; i--) {

            if (array[i] != 0) {
                array[aux] = array[i];
                aux--;
            }
        }
        while (aux >= 0) {
            array[aux] = 0;
            aux--;
        }
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " ");
        }
    }
    public static void main(String[] args) {
      int[] array = {2, 34, 15, 0, 12, 0, 3, 0, 55, 2, 0};
      moveNullElements(array);
    }
}
