package workshop4;

import java.util.Scanner;

public class Workshop4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductList pl = new ProductList();
        ProductView pv = new ProductView(pl);
        Shop s = new Shop(pl);
        int choice;
        String name;

        do {
            System.out.println("\n1. Add a new product");
            System.out.println("2. Update product information");
            System.out.println("3. A list of all available products in the Store");
            System.out.println("4. Sort all products by product price as ascending ");
            System.out.println("5. Print information of all products.");
            System.out.println("6. Exit ...");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    pv.add();
                    break;
                case 2:
                    System.out.println("\nEnter product name to update: ");
                    name = sc.nextLine();
                    pv.updateProduct(name);
                    break;
                case 3:
                    s.showAvailableProductList();
                    break;
                case 4:
                    s.sortProductByName();
                    break;
                case 5:
                    s.showProductList();
                    break;
                case 6:
                    System.out.println("\nExiting program...");
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
                    break;
            }
        } while (choice != 6);
    }
}
