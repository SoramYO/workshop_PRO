
package workshop4;


    public class Product {
    private String productId;
    private String productName;
    private double productPrice;
    private int availableQuantity;

    public Product(String productId, String productName, double productPrice, int availableQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.availableQuantity = availableQuantity;
    }

    public void updatePrice(double newPrice) {
        this.productPrice = newPrice;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public String getInfo() {
        return productId + ", " + productName + ", $" + productPrice + ", " + availableQuantity;
    }
}

