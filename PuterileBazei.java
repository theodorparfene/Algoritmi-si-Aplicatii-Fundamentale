import java.util.Scanner;

public class PuterileBazei {
    private static void showAllPowers(int base, int exponent) {
        int result = 1;
        System.out.print("Puterile bazei sunt: ");
        for (int i = 0; i <= exponent; i++) {
            if (i == 0) {
                // empty statement, does nothing
            } else {
                result *= base;
            }

            System.out.print(result + " ");
        }
    }

    private static int isValidExponent(Scanner sc) {
        int exponent = 0;
        do {
            System.out.println("Introduceti un exponent:");
            exponent = sc.nextInt();

            if (exponent < 0) {
                System.out.println("Exponentul trebuie sa fie pozitiv!");
            }
        } while (exponent < 0);
        return exponent;
    }


    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduceti o baza:");
        int base = sc.nextInt();

        showAllPowers(base, isValidExponent(sc));

        sc.close();
    }
}
