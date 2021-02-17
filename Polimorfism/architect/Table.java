package architect;

public class Table {
    private String material;
    private Dimensions dimensions;
    private double positionX;
    private double positionY;

    Table(String material, int length, int width, int height) {
        this.material = material;
        dimensions = new Dimensions(length, width, height);
    }

    Table(String material, int length, int width, int height, double positionX, double positionY) {
        this(material, length, width, height);
        this.positionX = positionX;
        this.positionY = positionY;
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
