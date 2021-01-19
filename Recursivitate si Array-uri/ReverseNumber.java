public class ReverseNumber {
    private static void reverseNumberR(int number) {
        if (number < 10) {
            System.out.print(number);
        } else {
            System.out.print(number % 10);
            reverseNumberR(number / 10);
        }
    }

    private static int reverseNumberI(int number) {
        int reverse = 0;
        while (number != 0) {
            reverse = reverse * 10 + (number % 10);
            number /= 10;
        }
        return reverse;
    }

    public static void main(String[] args) {
        reverseNumberR(1249);
        System.out.println("\n" + reverseNumberI(1249));
    }
}
