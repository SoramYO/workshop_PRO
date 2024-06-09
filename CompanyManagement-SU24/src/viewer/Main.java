package viewer;

import controller.CompanyManagement;

import java.util.Scanner;
import static viewer.Menu.addEmployee;
import static viewer.Menu.searchEmployee;
import static viewer.Menu.sortEmployee;
import static viewer.Menu.storeDataToFile;
import static viewer.Menu.updateEmployee;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] options = {
                "Show the Employee list",
                "Add Employee",
                "Update Employee",
                "Search Employee",
                "Store data to file",
                "Sort Employee",
                "Exit"
        };
        final String fileWrite = "src\\output\\EmployeeData.txt";
        CompanyManagement cm = null;

        try {
            cm = new CompanyManagement(fileWrite);
            System.out.println("\nWelcome to the Company Employee Management Program!");
            System.out.println(
                    "Note: All employee's salary is based on the actual salary after multiplying with the bonus and casting into integer.");
        } catch (Exception e) {
            System.out.println("Error initializing Company Management: " + e.getMessage());
            System.exit(0);
        }

        while (true) {
            printMenu(options);
            System.out.print("\nPlease enter your choice (1-" + options.length + "): ");
            int choice = 0;
            try {
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        CompanyManagement.printHeader("All Employees");
                        cm.printEmpList();
                        break;
                    case 2:
                        while (true) {
                            addEmployee(cm, sc);
                            System.out.println("Do you want to add more employee? (Y/N)");
                            String choiceYesNo = sc.nextLine();
                            if (choiceYesNo.equalsIgnoreCase("N")) {
                                break;
                            }
                        }
                        break;
                    case 3:
                        updateEmployee(cm, sc);
                        break;
                    case 4:
                        searchEmployee(cm, sc);
                        break;
                    case 5:
                        storeDataToFile(cm, fileWrite);
                        break;
                    case 6:
                        sortEmployee(cm, sc);
                        break;
                    case 7:
                        System.out.println("Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Please input a number from 1 to " + options.length);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    private static void printMenu(String[] options) {
        System.out.println("\nCompany Employee Management Program");
        System.out.println("-----------------------------------");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.println("-----------------------------------");
    }

}
