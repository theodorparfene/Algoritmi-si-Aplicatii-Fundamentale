import java.util.Scanner;

public class Complementar {
    private static int showComplementary(int number) {
        int roundSquared = 1;
        int aux = number;

        if (number == 0) {
            roundSquared = 10;
        } else {
            while (aux > 0) {
                aux = aux / 10;
                roundSquared *= 10;
            }
        }

        System.out.println("Numarul complementar este:");
        return (roundSquared - number);
    }

    private static int isValidNumber(Scanner sc) {
        int number = 0;
        do {
            System.out.println("Introduceti o valoare intreaga pozitiva:");
            number = sc.nextInt();

            if (number < 0) {
                System.out.println("Nu ati introdus o valoare pozitiva!");
            }
        } while (number < 0);
        return number;
    }

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(showComplementary(isValidNumber(sc)));

        sc.close();
    }
}
