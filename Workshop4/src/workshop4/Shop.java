package workshop4;

import java.util.Comparator;

public class Shop extends ProductList {

    public Shop(ProductList productList) {
    super();
    this.productList = productList.getProductList();
}


    public void showAvailableProductList() {
        System.out.println("List of available products:");
        int availableProductsCount = 0;
        for (int i = 0; i < productList.size(); i++) {
            Product pro = productList.get(i);
            if (pro.getAvailableProduct() > 0) {
                availableProductsCount++;
                System.out.println("Product " + availableProductsCount);
                System.out.println(pro.toString());
            }
        }
        if (availableProductsCount == 0) {
            System.out.println("No products are currently available.");
        }
    }

    public void sortProductByName() {
        System.out.println("All products sorted by product name in ascending order: ");
        productList.sort(Comparator.comparing(Product::getName));
        System.out.println("Sort product list success");
    }

    public void showProductList() {
        System.out.println("List of products:");
        for (int i = 0; i < productList.size(); i++) {
            System.out.println("Product " + (i + 1));
            Product product = productList.get(i);
            System.out.println(product.toString());
        }
    }

    public Product searchProductByName(String name) {
        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public Product searchProductByID(String code) {
        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            if (product.getID().equals(code)) {
                return product;
            }
        }
        return null;
    }
}
