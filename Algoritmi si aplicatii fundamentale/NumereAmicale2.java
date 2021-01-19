public class NumereAmicale2 {
    private static int sumDiv(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    private static boolean areFriends(int firstNumber, int secondNumber) {
        return firstNumber == sumDiv(secondNumber) && secondNumber == sumDiv(firstNumber);
    }

    private static void findAllFriends(int lower, int upper) {
        for (int i = lower; i <= upper; i++) {
            for (int j = i + 1; j <= upper; j++) {
                if (areFriends(i, j)) {
                    System.out.println(i + " - " + j);
                }
            }
        }
    }

    private static int findFriend(int number) {
        int possibleFriend = sumDiv(number);
        int sumDivofPossibleFriend = sumDiv(possibleFriend);

        if (sumDivofPossibleFriend == number && number < possibleFriend) {
            return possibleFriend;
        }
        return -1;
    }

    private static void findAllFriendsV2(int left, int right) {
        for (int i = left; i <= right; i++) {
            int possibleFriend = findFriend(i);
            if (possibleFriend != -1) {
                System.out.println(i + " " + possibleFriend);
            }
        }
    }

    public static void main(String [] args) {
        long startTime = System.nanoTime();
        findAllFriendsV2(1, 10000);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1000_000_000.0;
        System.out.println(duration);
    }
}
