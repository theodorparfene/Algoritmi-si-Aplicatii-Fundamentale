package architect;

public class Bed {
    private String ownerName;
    private String material;
    private Dimensions dimensions;
    private double positionX;
    private double positionY;

    Bed(String material, int length, int width, int height) {
        this.material = material;
        dimensions = new Dimensions(length, width, height);
    }

    Bed(String material, int length, int width, int height, double positionX, double positionY) {
        this(material, length, width, height);
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
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
