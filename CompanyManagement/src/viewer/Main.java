package viewer;

import model.Tester;
import model.Employee;
import java.util.*;
import controller.*;


public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        // Menu options
        String[] options = {"Read all Employees and print to screen",
            "Show staff proficient in a Programming Language", "Show Tester has a height salary",
            "Show Employee’s higest salary", "Show Leader of the Team has most Employees",
            "Sort Employees as descending salary", "Write file"};
        final String fileEmp = "src\\input\\ListOfEmployees.txt";
        final String filePL = "src\\input\\PLInfo.txt";
        //final String fileWrite1 = "src\\output\\Req2.txt";
        //final String fileWrite2 = "src\\output\\Req3.txt";
        int choice = 0;
        CompanyManagement cm = new CompanyManagement(fileEmp, filePL);
        System.out.println(
                "Note: \nAll employee's salary based on the actual salary after multiply with the bonus and casted into integer!!!");
        do {
            System.out.println("\nCompany Employee Management Program");
            choice = Menu.getChoice(options); // show Menu options
            switch (choice) {
                case 1:
                    ArrayList<Employee> list = cm.getEmployeeFromFile(fileEmp, filePL);
                    for (Employee employee : list) {
                        System.out.println(employee.toString());
                    }
                    break;
                case 2:
                    String s1;
                    System.out.println("Input programming language: ");
                    s1 = sc.nextLine();
                    ArrayList<Employee> listDeveloper = cm.getDeveloperByProgrammingLanguage(s1);
                    for (Employee employee : listDeveloper) {
                        System.out.println(employee.toString());
                    }
                    break;
                case 3:
                    double value;
                    System.out.println("Input value: ");
                    value = Double.parseDouble(sc.nextLine());
                    ArrayList<Tester> listTester = cm.getTestersHaveSalaryGreaterThan(value);
                    for (Tester tester : listTester) {
                        System.out.println(tester.toString());
                    }
                    break;

                case 4:
                    cm.getEmployeeWithHighestSalary();
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
