package surprise;

public class Candies implements ISurprise {

    private String candyType;
    private int noOfCandies;

    Candies(String candyType, int noOfCandies) {
        this.candyType = candyType;
        this.noOfCandies = noOfCandies;
    }

    static Candies generate() {
        String candyType = CandyTypes.getCandyTypeList().get(RandomSelector.random.nextInt(CandyTypes.getCandyTypeList().size()));
        int noOfCandies = RandomSelector.random.nextInt(20);
        return new Candies(candyType, noOfCandies);
    }

    @Override
    public void enjoy() {
        System.out.println(candyType + " and " + noOfCandies);
    }

    @Override
    public String toString() {
        return "Candy Type : " + this.candyType + " || Number of Candies : " + this.noOfCandies;
    }
}
