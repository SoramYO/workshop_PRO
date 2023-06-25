package workshop4;

import java.util.ArrayList;

public class ProductList {
    protected ArrayList<Product> productList;

    public ProductList() {
        this.productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.productList.add(product);
    }
    public ArrayList<Product> getProductList() {
    return productList;
}

}
