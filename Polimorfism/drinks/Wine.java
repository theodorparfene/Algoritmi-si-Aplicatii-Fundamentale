package drinks;

public class Wine extends Alcohol{
    private String brand;
    private String type;

    public Wine(double phLevel, double volume, int alcoholLvl, String brand, String type) {
        super(phLevel, volume, alcoholLvl);
        this.brand = brand;
        this.type = type;
    }

    @Override
    public void showInfo() {
        System.out.println("Wine Characteristics\n" +
                            "\nType of wine: " + this.type +
                            "\nBrand: " + this.brand +
                            "\nAcohol Percentage: " + this.getAlcoholLvl() +
                            "\npH Level: " + this.getPhLevel() +
                            "\nVolume in liters: " + this.getVolume());
    }
}
