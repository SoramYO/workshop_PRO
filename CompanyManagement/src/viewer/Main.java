package viewer;

import model.Tester;
import model.Employee;
import java.util.*;
import controller.*;


public class Main {

    public static void main(String[] args) throws Exception {
        // Menu options
        String[] options = {"Read all Employees and print to screen",
            "Show staff proficient in a Programming Language", "Show Tester has a height salary",
            "Show Employee’s higest salary", "Show Leader of the Team has most Employees",
            "Sort Employees as descending salary", "Write file"};
        final String fileEmp = "src\\input\\ListOfEmployees.txt";
        final String filePL = "src\\input\\PLInfo.txt";
        final String fileWrite1 = "src\\output\\Req2.txt";
        final String fileWrite2 = "src\\output\\Req3.txt";
        int choice = 0;
        CompanyManagement cm = new CompanyManagement(fileEmp, filePL);
        System.out.println(
                "Note: \nAll employee's salary based on the actual salary after multiply with the bonus and casted into integer!!!");
        do {
            System.out.println("\nCompany Employee Management Program");
            choice = Menu.getChoice(options); // show Menu options
            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7: // write file

                    break;
                default:
                    System.out.println("Good bye!");
            }
        } while (choice > 0 && choice < options.length);
    }
}
