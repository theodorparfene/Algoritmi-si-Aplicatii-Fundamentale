import java.util.ArrayList;
import java.util.Collections;

public class FrecventaMaximaV2 {
    private static void showMinMax(String str){
        str = str.toLowerCase();
        str = str.replaceAll("\\s+", "");
        int maxFreq = 0;
        ArrayList<Character> strList = new ArrayList<Character>();
        ArrayList<Character> listResult = new ArrayList<Character>();
        for (char ch : str.toCharArray()) {
            strList.add(ch);
        }


        for (int i = 0; i < strList.size(); i++) {
            int chFreq = Collections.frequency(strList, strList.get(i));
            if (i > 0 && chFreq > maxFreq) {
                listResult.clear();
            }
            System.out.println(listResult);
            if (chFreq >= maxFreq) {
                maxFreq = chFreq;
                if (!listResult.contains(strList.get(i))) {
                    listResult.add(strList.get(i));
                }
            }
        }
        for (char ch : listResult) {
            System.out.println("Character '" + ch +
                    "' appears " + maxFreq + " times.");
        }
    }

    public static void main(String[] args) {
        showMinMax("3 sud est e fara rest");
    }
}