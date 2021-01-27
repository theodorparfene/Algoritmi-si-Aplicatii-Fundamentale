public class Product {
    private String name;
    private int price;
    private double weight; //kg
    private int quantity;

    public Product(String name) {
        this.name = name;
    }

    public Product(String name, int price, double weight, int quantity) {
        this(name);
        this.price = price;
        this.weight = weight;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
