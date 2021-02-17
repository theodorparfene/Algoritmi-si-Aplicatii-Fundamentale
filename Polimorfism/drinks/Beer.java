package drinks;

public class Beer extends Alcohol{
    private String brand;
    private String type;

    public Beer(double phLevel, double volume, int alcoholLvl, String brand, String type) {
        super(phLevel, volume, alcoholLvl);
        this.brand = brand;
        this.type = type;
    }

    @Override
    public void showInfo() {
        System.out.println("Beer Characteristics\n" +
                            "\nType of beer: " + this.type +
                            "\nBrand: " + this.brand +
                            "\nAcohol Percentage: " + this.getAlcoholLvl() +
                            "\npH Level: " + this.getPhLevel() +
                            "\nVolume in liters: " + this.getVolume());
    }
}
