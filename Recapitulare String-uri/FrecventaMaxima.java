public class FrecventaMaxima {
    private static void showMinMax(String str) {
        str = str.toLowerCase();
        str = str.replaceAll("\\s+", "");
        int maxFreq = 0;
        int minFreq = str.length();
        for (int i = 0; i < str.length(); i++) {
            int chFreq = 1;
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    chFreq++;
                }
            }
            if (chFreq > maxFreq) {
                maxFreq = chFreq;
            }
            if (chFreq < minFreq) {
                minFreq = chFreq;
            }
        }

        for (int i = 0; i < str.length(); i++) {
            int chFreq = 1;
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    chFreq++;
                }
            }
            if (chFreq == maxFreq) {
                System.out.println("Character '" + str.charAt(i) +
                        "' appears " + maxFreq + " times.MAX");
            }

            if (chFreq == minFreq) {
                System.out.println("Character '" + str.charAt(i) +
                        "' appears " + minFreq + " times.MIN");
            }
        }
    }

    public static void main(String[] args) {
        showMinMax("3 sud est au rasarit");
    }
}
