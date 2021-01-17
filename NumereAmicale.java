import java.util.Scanner;

public class NumereAmicale {

    private static int findAllDivisors(int number) {
        int result = 0;
        for(int i=  1; i <= number / 2; i++) {
            if (number % i == 0) {
                result += i;
            }
        }
        return result;
    }

    private static boolean isComputable(int firstNumber, int secondNumber) {
        int firstNumberTry = findAllDivisors(firstNumber);
        int secondnumberTry = findAllDivisors(secondNumber);
        return firstNumberTry == secondNumber && secondnumberTry == firstNumber;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lowerLimit = sc.nextInt();
        int upperLimit = sc.nextInt();

        for(int i = lowerLimit; i <= upperLimit; i++) {
            for(int j = i + 1; j <= upperLimit; j++) {
                if (isComputable(i, j)) {
                    System.out.println(i + " " + j);
                }
            }
        }
        sc.close();
    }
}
