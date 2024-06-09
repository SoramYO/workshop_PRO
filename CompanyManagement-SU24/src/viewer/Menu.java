package viewer;

import controller.CompanyManagement;
import static controller.CompanyManagement.sortEmployeeByName;
import static controller.CompanyManagement.sortEmployeeBySalary;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Developer;
import model.Employee;
import model.TeamLeader;
import model.Tester;

public class Menu {
    public static void addEmployee(CompanyManagement cm, Scanner sc) {
        System.out.println("--- Add Employee ---");
        System.out.println("1. Tester");
        System.out.println("2. Developer");
        System.out.println("3. Team Leader");
        int type;
        try {

            while (true) {
                System.out.println("Select Employee Type:");
                type = Integer.parseInt(sc.nextLine());
                if (type < 1 || type > 3) {
                    System.out.println("Invalid choice. Please select a number between 1 and 3.");
                } else {
                    break;
                }
            }

            String empID;
            while (true) {
                System.out.print("Enter employee code: ");
                empID = sc.nextLine();
                if (cm.searchEmployeeById(empID)) {
                    System.out
                            .println("Employee with ID " + empID + " already exists. Please enter a different ID.");
                } else {
                    break;
                }
            }
            System.out.print("Enter employee name: ");
            String empName = sc.nextLine();
            System.out.print("Enter base salary: ");
            double baseSalary = Double.parseDouble(sc.nextLine());

            switch (type) {
                case 1:
                    System.out.print("Enter bonus rate: ");
                    double bonusRate = Double.parseDouble(sc.nextLine());
                    System.out.print("Enter tester type AT/MT (Automation Test - Manual Test): ");
                    while (true) {
                        String testerType = sc.nextLine();
                        if (testerType.equals("AT") || testerType.equals("MT")) {
                            cm.addEmployee(new Tester(empID, empName, baseSalary, testerType, bonusRate));
                            break;
                        } else {
                            System.out.println("Invalid input. Please enter AT or MT.");
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter programming languages (comma separated): ");
                    String[] plArray = sc.nextLine().split(",");
                    ArrayList<String> programmingLanguages = new ArrayList<>();
                    for (String pl : plArray) {
                        programmingLanguages.add(pl.trim());
                    }
                    System.out.print("Enter team name: ");
                    String teamName = sc.nextLine();

                    System.out.print("Enter years of experience: ");
                    int yearsOfExperience = Integer.parseInt(sc.nextLine());
                    cm.addEmployee(
                            new Developer(empID, programmingLanguages, empName, teamName, yearsOfExperience,
                                    baseSalary));
                    break;
                case 3:
                    System.out.print("Enter programming languages (comma separated): ");
                    plArray = sc.nextLine().split(",");
                    programmingLanguages = new ArrayList<>();
                    for (String pl : plArray) {
                        programmingLanguages.add(pl.trim());
                    }
                    System.out.print("Enter team name: ");
                    teamName = sc.nextLine();
                    if (cm.checkTeamHaveLeader(teamName)) {
                        System.out.println("This team already has a leader. Please choose another team.");
                        break;
                    }
                    System.out.print("Enter years of experience: ");
                    yearsOfExperience = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter additional income rate: ");
                    bonusRate = Double.parseDouble(sc.nextLine());
                    cm.addEmployee(new TeamLeader(empID, programmingLanguages, empName, teamName, yearsOfExperience,
                            bonusRate, baseSalary));

                default:
                    System.out.println("Must choose a number between 1 and 3.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        } catch (Exception e) {
            System.out.println("Error adding employee: " + e.getMessage());
        }
    }

    public static void updateEmployee(CompanyManagement cm, Scanner sc) {
        while (true) {
            System.out.print("Enter employee code to update or type 'menu' to return to main menu: ");
            String empID = sc.nextLine();
            if (empID.equalsIgnoreCase("menu")) {
                return;
            }

            Employee employee = cm.searchEmployeeRoleById(empID);
            if (employee == null) {
                System.out.println("Employee not found.");
                continue;
            }

            System.out.println("Old information: ");
            System.out.println(employee);
            System.out.println("Enter new information: ");

            System.out.print("Enter employee name (" + employee.getEmpName() + "): ");
            String empName = sc.nextLine();
            if (!empName.isEmpty()) {
                employee.setEmpName(empName);
            }

            System.out.print("Enter base salary (" + employee.getBaseBal() + "): ");
            String baseSal = sc.nextLine();
            if (!baseSal.isEmpty()) {
                try {
                    double baseSalary = Double.parseDouble(baseSal);
                    employee.setBaseBal(baseSalary);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Base salary must be a valid number.");
                }
            }

            if (employee instanceof Tester) {
                Tester tester = (Tester) employee;

                System.out.print("Enter bonus rate (" + tester.getBonusRate() + "): ");
                String bonusRate = sc.nextLine();
                if (!bonusRate.isEmpty()) {
                    try {
                        tester.setBonusRate(Double.parseDouble(bonusRate));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Bonus rate must be a valid number.");
                    }
                }

                System.out.print("Enter tester type (" + tester.getType() + "): ");
                String testerType = sc.nextLine();
                if (!testerType.isEmpty()) {
                    if (testerType.equals("AT") || testerType.equals("MT")) {
                        tester.setType(testerType);
                    } else {
                        System.out.println("Invalid input. Tester type must be AT or MT.");
                    }
                }
            } else if (employee instanceof Developer) {
                Developer developer = (Developer) employee;

                System.out.print("Enter team name (" + developer.getTeamName() + "): ");
                String teamName = sc.nextLine();
                if (!teamName.isEmpty()) {
                    developer.setTeamName(teamName);
                }

                System.out.print("Enter programming languages (comma separated) ("
                        + developer.getProgrammingLanguages().toString() + "): ");
                String[] plArray = sc.nextLine().split(",");
                ArrayList<String> programmingLanguages = new ArrayList<>();
                if (plArray.length > 0) {
                    for (String pl : plArray) {
                        programmingLanguages.add(pl.trim());
                    }
                    developer.setProgrammingLanguages(programmingLanguages);
                }

                System.out.print("Enter years of experience (" + developer.getExpYear() + "): ");
                String expYear = sc.nextLine();
                if (!expYear.isEmpty()) {
                    try {
                        developer.setExpYear(Integer.parseInt(expYear));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Years of experience must be a valid number.");
                    }
                }
            } else if (employee instanceof TeamLeader) {
                TeamLeader teamLeader = (TeamLeader) employee;

                System.out.print("Enter team name (" + teamLeader.getTeamName() + "): ");
                String teamName = sc.nextLine();
                if (!teamName.isEmpty()) {
                    if (cm.checkTeamHaveLeader(teamName)) {
                        System.out.println("This team already has a leader. Please choose another team.");
                        continue;
                    } else {
                        teamLeader.setTeamName(teamName);
                    }
                }

                System.out.print("Enter programming languages (comma separated) ("
                        + teamLeader.getProgrammingLanguages().toString() + "): ");
                String[] plArray = sc.nextLine().split(",");
                ArrayList<String> programmingLanguages = new ArrayList<>();
                if (plArray.length > 0) {
                    for (String pl : plArray) {
                        programmingLanguages.add(pl.trim());
                    }
                    teamLeader.setProgrammingLanguages(programmingLanguages);
                }

                System.out.print("Enter years of experience (" + teamLeader.getExpYear() + "): ");
                String expYear = sc.nextLine();
                if (!expYear.isEmpty()) {
                    try {
                        teamLeader.setExpYear(Integer.parseInt(expYear));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Years of experience must be a valid number.");
                    }
                }

                System.out.print("Enter additional income rate (" + teamLeader.getBonus_rate() + "): ");
                String bonusRate = sc.nextLine();
                if (!bonusRate.isEmpty()) {
                    try {
                        teamLeader.setBonus_rate(Double.parseDouble(bonusRate));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Additional income rate must be a valid number.");
                    }
                }
            }

            if (cm.updateEmployee(empID, employee)) {
                System.out.println("Employee updated successfully.");
            } else {
                System.out.println("Failed to update employee.");
            }

            System.out.println("Do you want to update another employee? (Y/N)");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("N")) {
                return;
            }
        }
    }

    public static void sortEmployee(CompanyManagement cm, Scanner sc) {
        System.out.println("Sort employee in ascending :");
        System.out.println("1. By name");
        System.out.println("2. By salary ");
        System.out.println("Choose the way to sort: ");
        int searchChoice = Integer.parseInt(sc.nextLine());

        switch (searchChoice) {
            case 1:
                sortEmployeeByName(cm);
                break;
            case 2:
                sortEmployeeBySalary(cm);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void searchEmployee(CompanyManagement cm, Scanner sc) {
        System.out.println("Search Employee:");
        System.out.println("1. By name");
        System.out.println("2. By salary higher value");
        System.out.println("3. By programming languages");
        int searchChoice = Integer.parseInt(sc.nextLine());

        switch (searchChoice) {
            case 1:
                searchByName(cm, sc);
                break;
            case 2:
                searchBySalary(cm, sc);
                break;
            case 3:
                searchByProgrammingLanguages(cm, sc);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void searchByName(CompanyManagement cm, Scanner sc) {
        System.out.print("Enter employee name: ");
        String name = sc.nextLine();
        Employee employee = cm.searchEmployeeByName(name);
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found.");
        }
    }

    public static void searchBySalary(CompanyManagement cm, Scanner sc) {
        System.out.print("Enter salary value: ");
        double salary = Double.parseDouble(sc.nextLine());
        ArrayList<Employee> employees = cm.searchEmployeeBySalary(salary);
        if (!employees.isEmpty()) {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        } else {
            System.out.println("No employees found with salary greater than " + salary);
        }
    }

    public static void searchByProgrammingLanguages(CompanyManagement cm, Scanner sc) {
        System.out.print("Enter programming language: ");
        String language = sc.nextLine();
        ArrayList<Employee> employees = cm.searchEmployeeByProgrammingLanguage(language);
        if (!employees.isEmpty()) {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        } else {
            System.out.println("No employees found proficient in " + language);
        }
    }

    public static void storeDataToFile(CompanyManagement cm, String filePath) throws IOException {
        if (cm.writeFile(filePath, cm.getEmpList())) {
            System.out.println("Data stored to file successfully.");
        } else {
            System.out.println("Failed to store data to file.");
        }
    }
}
