public class RidicarePutere {
    private static int mathPowR(int base, int exponent) {
        if (exponent == 1) {
            return base;
        }
        if (exponent == 0) {
            return 1;
        }

        return base * mathPowR(base, exponent - 1);
    }

    private static int mathPowI(int base, int exponent) {
        int result = 1;
        for (int i = 1; i <= exponent; i++) {
            if (exponent == 0) {
                return result;
            }
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(mathPowR(3,3));
        System.out.println(mathPowI(3,3));
    }
}
