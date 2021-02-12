public class Triangle extends Shape {
    private int base;
    private int height;

    public Triangle() {
        super("\u0000", "\u0000");
    }

    public Triangle(String text, String material, int base, int height) {
        super(text, material);
        this.base = base;
        this.height = height;
    }

    public void displayTriangleHeight() {
        System.out.println("Triangle height is: " + this.height);
    }

    @Override
    public double getSize() {
        return (this.base * this.height) / 2d;
    }

    @Override
    public String toString() {
        return "Triangle: Height is " + this.height + ". Base is " + this.base + ", " + super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (this.getClass() == obj.getClass()) {
            return false;
        }

        Triangle triangleObj = (Triangle) obj;
        if (super.equals(triangleObj) &&
            this.height == triangleObj.height &&
            this.base == triangleObj.base) {

            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = super.hashCode();
        result = prime * result + (base + prime) + height;
        result = prime * result + (base + prime) + base;
        return result;
    }
}
