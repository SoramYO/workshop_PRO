package workshop4;

import java.util.ArrayList;

public class ProductList {
    private final ArrayList<Product> productList;

    public ProductList() {
        this.productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.productList.add(product);
    }

    public int getIndexOf(Product product) {
        return this.productList.indexOf(product);
    }
    public Product[] getArray() {
    return productList.toArray(new Product[0]);
}

}
