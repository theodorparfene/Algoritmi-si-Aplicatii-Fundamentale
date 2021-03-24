package surprise;

import java.util.List;

public class Minions {
    //Not sure how I feel about having this in the class itself, so here it is, in a different class!
    private final static List<String> minions = List.of("Dave", "Carl", "Kevin", "Stuart", "Jerry", "Tim");

    public static List<String> getMinions() {
        return minions;
    }
}
