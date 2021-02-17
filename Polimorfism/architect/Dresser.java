package architect;

public class Dresser {
    private int clothesNo;
    private String material;
    private Dimensions dimensions;
    private double positionX;
    private double positionY;

    Dresser(String material, int length, int width, int height) {
        this.material = material;
        dimensions = new Dimensions(length, width, height);
    }

    Dresser(String material, int length, int width, int height, double positionX, double positionY) {
        this(material, length, width, height);
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void addClothes(int amount) {
        this.clothesNo += amount;
    }

    public int getClothesNo() {
        return clothesNo;
    }


    public String getMaterial() {
        return material;
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

}
