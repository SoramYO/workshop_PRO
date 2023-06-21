package workshop4;

import java.util.Arrays;
import java.util.Comparator;

public class Shop extends ProductList {

    public void showAvailableProductList() {
        Product[] productArray = getArray();
        System.out.println("List of available products:");
        int availableProductsCount = 0;
        for (int i = 0; i < productArray.length; i++) {
            if (productArray[i].getAvailableProduct() > 0) {
                availableProductsCount++;
                System.out.println("Product " + availableProductsCount);
                System.out.println(productArray[i].toString());
            }
        }
        if (availableProductsCount == 0) {
            System.out.println("No products are currently available.");
        }
    }

    public void sortProductByName() {
        Product[] productArray = getArray();
        Arrays.sort(productArray, Comparator.comparing(Product::getName));
        System.out.println("Sort product list success");
    }

    public void showProductList() {
        Product[] productArray = getArray();
        System.out.println("List of products:");
        for (int i = 0; i < productArray.length; i++) {
            System.out.println("Product " + (i + 1));
            Product prod = productArray[i];
            System.out.println(prod.toString());
        }
    }

    public Product searchProductByName(String name) {
        Product[] productArray = getArray();
        for (int i = 0; i < productArray.length; i++) {
            Product product = productArray[i];
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public Product searchProductByID(String code) {
        Product[] productArray = getArray();
        for (int i = 0; i < productArray.length; i++) {
            Product product = productArray[i];
            if (product.getID().equals(code)) {
                return product;
            }
        }
        return null;
    }

}
