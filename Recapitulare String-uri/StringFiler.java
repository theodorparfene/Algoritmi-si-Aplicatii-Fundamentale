import java.util.Arrays;

public class StringFiler {
    private static String[] filterWords(String[] words, String key, int matchKey) {
        int initCapacity = 0;
        int index = 0;
        key = key.toLowerCase();
        String[] matchingWords = new String[initCapacity];
        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i].toLowerCase();
            int counter = 0;
            for (int j = 0; j < words[i].length(); j++) {
                if (currentWord.charAt(j) == key.charAt(j)) {
                    counter++;
                }
                if (key.indexOf(key.charAt(j)) == key.length() - 1) {
                    break;
                }
            }
            if (counter >= matchKey) {
                matchingWords = Arrays.copyOf(matchingWords, matchingWords.length + 1);
                matchingWords[index] = words[i];
                index++;
            }
        }
        return matchingWords;
    }



    public static void main(String[] args) {
        String[] words = {"clothes", "ant", "drop", "Fly", "racoon", "class", "Plane"};
        System.out.println(Arrays.toString(filterWords(words, "plot", 3)));
    }
}
