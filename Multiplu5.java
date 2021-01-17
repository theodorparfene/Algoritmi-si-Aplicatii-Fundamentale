import java.util.Scanner;

public class Multiplu5 {
    private static int getMultipleOf5Lower(int number) {
        int result = 0;
        for (int i = number - 5; i <= number; i++) {
            if (i % 5 == 0) {
                result = i;
            }
        }
        return result;
    }

    private static int getMultipleOf5Upper(int number) {
        int result = 0;
        for (int i = number; i <= number + 5; i++) {
            if (i % 5 == 0) {
                result = i;
                break;
            }
        }
        return result;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println(getMultipleOf5Lower(number));
        System.out.println(getMultipleOf5Upper(number));
        sc.close();
    }
}
