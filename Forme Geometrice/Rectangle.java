public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle() {
        super("\u0000", "\u0000");
    }

    public Rectangle(String text, String material, int width, int height) {
        super(text, material);
        this.width = width;
        this.height = height;
    }

    public void displayRectangleHeight() {
        System.out.println("Rectangle height is: " + this.height);
    }

    @Override
    public double getSize() {
        return this.width * this.height;
    }

    @Override
    public String toString() {
        return "Rectangle: Height is " + this.height + ". Width is " + this.width + ", " + super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Rectangle rectangleObj = (Rectangle) obj;
        if (super.equals(rectangleObj) &&
            this.height == rectangleObj.height &&
            this.width == rectangleObj.width) {

            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = super.hashCode();
        result = prime * result + (width - prime) + height;
        result = prime * result + (width - prime) + width;
        return result;
    }
}
