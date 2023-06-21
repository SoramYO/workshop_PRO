package workshop4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductView {
    private final ProductList pl;

    public ProductView(ProductList pl) {
        this.pl = pl;
    }

    public void add() {
        Scanner sc = new Scanner(System.in);
        String id, name;
        double price;
        int aProduct;

        System.out.println("Enter product ID:");
        id = sc.nextLine();

        System.out.println("\nEnter full name:");
        name = sc.nextLine();

        System.out.println("\nEnter price:");
        price = sc.nextDouble();

        System.out.println("\nEnter available product:");
        aProduct = sc.nextInt();

        Product pro = new Product(id, name, price, aProduct);
        ProductList pl = new ProductList();
        pl.addProduct(pro);
        System.out.println("Add product success!\n");
    }

    public void updateProduct(String name) {
        Shop shop = new Shop();
        Product productToUpdate = shop.searchProductByName(name);

        if (productToUpdate != null) {
            Scanner sc = new Scanner(System.in);
            String id;
            double price;
            int availableProduct;

            System.out.println("Update product ID (" + productToUpdate.getID() + "):");
            id = sc.nextLine();
            if (!id.isEmpty()) {
                productToUpdate.setID(id);
            }

            System.out.println("Update product name (" + productToUpdate.getName() + "):");
            name = sc.nextLine();
            if (!name.isEmpty()) {
                productToUpdate.setName(name);
            }

            System.out.println("Update product price (" + productToUpdate.getPrice() + "):");
            try {
                price = Double.parseDouble(sc.nextLine());
                productToUpdate.setPrice(price);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Price must be a number.");
            }

            System.out.println("Update available product quantity (" + productToUpdate.getAvailableProduct() + "):");
            try {
                availableProduct = Integer.parseInt(sc.nextLine());
                if (availableProduct >= 0) {
                    productToUpdate.setAvailableProduct(availableProduct);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Quantity must be an integer.");
            }
            System.out.println("Update product success!\n");
        } else {
            System.out.println("Error: product not found.");
        }
    }

}
