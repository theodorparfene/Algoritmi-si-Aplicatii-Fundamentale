import java.util.Arrays;

public class AnagramSolver {
    private static boolean anagramSolver(String anag1, String anag2) {
        StringBuilder sb1 = new StringBuilder(anag1.toLowerCase());
        StringBuilder sb2 = new StringBuilder(anag2.toLowerCase());
        anag1 = removeSpecialChars(sb1);
        anag2 = removeSpecialChars(sb2);

        char[] arr1 = anag1.toCharArray();
        char[] arr2 = anag2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        anag1 = new String(arr1);
        anag2 = new String(arr2);

        return anag1.equals(anag2);
    }

    private static String removeSpecialChars(StringBuilder sb) {
        int counter = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (Character.isLetter(sb.charAt(i))) {
                sb.setCharAt(counter++, sb.charAt(i));
            }
        }
        sb.delete(counter, sb.length());
        return sb.toString();
    }

    public static void main(String[] args) {
        String anag1 = "fairy tales!";
        String anag2 = "rail, safety";

        System.out.println(anagramSolver(anag1, anag2));
    }
}
