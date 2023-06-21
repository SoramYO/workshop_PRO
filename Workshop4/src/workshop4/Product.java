package workshop4;

public class Product {

    private String ID;
    private String name;
    private double price;
    private int availableProduct;

    public Product() {
    }

    public Product(String ID, String name, double price, int availableProduct) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.availableProduct = availableProduct;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAvailableProduct() {
        return availableProduct;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailableProduct(int availableProduct) {
        this.availableProduct = availableProduct;
    }

    @Override
    public String toString() {
        return "Name: " + getName()
               + "\nID: " + getID()
               + "\nPrice: " + getPrice()
               + "\nAvailable Product: " + getAvailableProduct();

    }
}
