package workshop4;

import java.util.List;

public class Workshop4 {

    public static void main(String[] args) {
        Store store = new Store();

// Add a new product
        Product product1 = new Product("001", "Paracetamol", 5.99, 10);
        store.addProduct(product1);

// Update price of a product
        store.updatePrice("001", 6.50);

// Get list of available products
        List<Product> availableProducts = store.getAvailableProducts();

// Sort products by price ascending
        store.sortProductsByPrice();

// Print information of all products
        store.printAllProducts();

    }

}
