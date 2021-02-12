public class Shape {
     private String text;
     private String material;

    public Shape() {
        this.text = "\u0000";
        this.material = "\u0000";
    }

    public Shape(String text, String material) {
        this.text = text;
        this.material = material;
    }

    public double getSize() {
        return -1;
    }

    @Override
    public String toString() {
        return "Made of " + this.material + ". Contains the text: " + this.text;
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

        Shape other = (Shape) obj;
        if (this.text.equals(other.text) && this.material.equals(other.material)) {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((text == null) ? 0 : text.hashCode());
        result = prime * result + ((material == null) ? 0 : material.hashCode());
        return result;
    }
}
