package surprise;

import java.util.List;

public class CandyTypes {
    //Not sure how I feel about having this in the class itself, so here it is, in a different class!
    private final static List<String> candyTypeList = List.of("chocolate", "jelly", "fruits", "vanilla");

    public static List<String> getCandyTypeList() {
        return candyTypeList;
    }
}
