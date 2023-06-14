
package workshop4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Store {
    private List<Product> products;

    public Store() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void updatePrice(String productId, double newPrice) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                product.updatePrice(newPrice);
                break;
            }
        }
    }

    public List<Product> getAvailableProducts() {
        List<Product> availableProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getAvailableQuantity() > 0) {
                availableProducts.add(product);
            }
        }
        return availableProducts;
    }

    public void sortProductsByPrice() {
        Collections.sort(products, Comparator.comparingDouble(Product::getProductPrice));
    }

    public void printAllProducts() {
        for (Product product : products) {
            System.out.println(product.getInfo());
        }
    }
}
