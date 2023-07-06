package viewer;

import java.util.ArrayList;
import java.util.Scanner;
import controller.CompanyManagement;
import model.Employee;
import model.Tester;
import model.TeamLeader;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String[] options = {"Read all Employees and print to screen",
            "Show staff proficient in a Programming Language",
            "Show Tester with a higher salary",
            "Show Employee with the highest salary",
            "Show Team Leader with the most Employees",
            "Sort Employees by descending salary",
            "Write Employee list to file"};
        final String fileEmp = "src/input/ListOfEmployees.txt";
        final String filePL = "src/input/PLInfo.txt";
        final String fileReq2 = "src/output/Req2.txt";
        final String fileReq3 = "src/output/Req3.txt";

        CompanyManagement cm = new CompanyManagement(fileEmp, filePL);

        System.out.println("Note: All employee's salary is based on the actual salary after multiplying with the bonus and casted into integer!!!");

        int choice;
        do {
            System.out.println("\nCompany Employee Management Program");
            choice = Menu.getChoice(options); // Show menu options

            switch (choice) {
                case 1:
                    ArrayList<Employee> list = cm.getEmployeeList();
                    for (Employee employee : list) {
                        System.out.println(employee.toString());
                    }
                    break;
                case 2:
                    System.out.println("Input programming language: ");
                    String programmingLanguage = sc.nextLine();
                    ArrayList<Employee> staffList = cm.getDeveloperByProgrammingLanguage(programmingLanguage);
                    for (Employee employee : staffList) {
                        System.out.println(employee.toString());
                    }
                    break;
                case 3:
                    System.out.println("Testers with the highest salary:");
                    ArrayList<Tester> testerList = cm.getTestersHaveSalaryGreaterThan(0);
                    double highestSalary = 0;
                    for (Tester tester : testerList) {
                        if (tester.getSalary() > highestSalary) {
                            highestSalary = tester.getSalary();
                        }
                    }
                    for (Tester tester : testerList) {
                        if (tester.getSalary() == highestSalary) {
                            System.out.println(tester.toString());
                        }
                    }
                    break;
                case 4:
                    Employee emp = cm.getEmployeeWithHighestSalary();
                    System.out.println("Employee with the highest salary:");
                    System.out.println(emp.toString());
                    break;
                case 5:
                    TeamLeader leader = cm.getLeaderWithMostEmployees();
                    if (leader != null) {
                        System.out.println("Leader of the Team with the most Employees:");
                        System.out.println(leader.toString());
                    } else {
                        System.out.println("No team leader found for the team with the most Employees.");
                    }
                    break;
                case 6:
                    ArrayList<Employee> sortedList = cm.sorted();
                    System.out.println("Employees sorted by descending salary:");
                    for (Employee employee : sortedList) {
                        System.out.println(employee.toString());
                    }
                    break;
                case 7:
                    int fileChoice;
                    do {
                        System.out.println("\nWRITE FILE MENU");
                        System.out.println("1. Write staff proficient in C++ to Req2.txt");
                        System.out.println("2. Write employees with salary > 4,700,000 to Req3.txt");
                        System.out.println("3. Back to main menu");
                        System.out.print("Enter your choice: ");
                        fileChoice = sc.nextInt();

                        switch (fileChoice) {
                            case 1:
                                ArrayList<Employee> cppDevs = cm.getDeveloperByProgrammingLanguage("C++");
                                boolean writeReq2Success = cm.writeEmployeeListToFile(fileReq2, cppDevs);
                                if (writeReq2Success) {
                                    System.out.println("Req2.txt file written successfully. Path: output/Req2.txt");
                                } else {
                                    System.out.println("Error writing Req2.txt file.");
                                }
                                break;
                            case 2:
                                ArrayList<Tester> highSalaryTesters = cm.getTestersHaveSalaryGreaterThan(4700000);
                                boolean writeReq3Success = cm.writeEmployeeListToFile(fileReq3, highSalaryTesters);
                                if (writeReq3Success) {
                                    System.out.println("Req3.txt file written successfully. Path: output/Req3.txt");
                                } else {
                                    System.out.println("Error writing Req3.txt file.");
                                }
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                    } while (fileChoice != 3);

                    break;
                case 8:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 8);
    }
}
