package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import model.Developer;
import model.TeamLeader;
import model.Tester;
import model.Employee;
import validation.Until;

public class CompanyManagement {
    Until valid = new Until();
    private ArrayList<Employee> empList;

    public CompanyManagement(String path) throws Exception {
        empList = getEmployeeFromFile(path);
    }

    public ArrayList<Employee> getEmpList() {
        return empList;
    }

    public void addEmployee(Employee employee) {
        empList.add(employee);
    }

    public boolean updateEmployee(String code, Employee updatedEmployee) {
        for (int i = 0; i < empList.size(); i++) {
            if (empList.get(i).getEmpID().equals(code)) {
                empList.set(i, updatedEmployee);
                return true;
            }
        }
        return false;
    }

    public Employee searchEmployeeByName(String name) {
        for (Employee employee : empList) {
            if (employee.getEmpName().equalsIgnoreCase(name)) {
                return employee;
            }
        }
        return null;
    }

    public Employee searchEmployeeRoleById(String id) {
        for (Employee employee : empList) {
            if (employee.getEmpID().equalsIgnoreCase(id)) {
                if (employee instanceof Tester) {
                    return (Tester) employee;
                }
                if (employee instanceof Developer) {
                    return (Developer) employee;
                }
                if (employee instanceof TeamLeader) {
                    return (TeamLeader) employee;
                }
            }
        }
        return null;
    }

    public boolean searchEmployeeById(String id) {
        for (Employee employee : empList) {
            if (employee.getEmpID().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkTeamHaveLeader(String teamName) {
        for (Employee employee : empList) {
            if (employee instanceof TeamLeader) {
                if (((TeamLeader) employee).getTeamName().equalsIgnoreCase(teamName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<Employee> searchEmployeeBySalary(double salary) {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : empList) {
            if (employee.getSalary() > salary) {
                result.add(employee);
            }
        }
        return result;
    }

    public ArrayList<Employee> searchEmployeeByProgrammingLanguage(String language) {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : empList) {
            if (employee instanceof Developer) {
                if (((Developer) employee).getProgrammingLanguages().contains(language)) {
                    result.add(employee);
                }
            }
        }
        return result;
    }

    public static void sortEmployeeByName(CompanyManagement cm) {
        ArrayList<Employee> sortedList = cm.getEmpList();

        Collections.sort(sortedList, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                String[] name1 = e1.getEmpName().split(" ");
                String[] name2 = e2.getEmpName().split(" ");
                String lastName1 = name1[name1.length - 1];
                String lastName2 = name2[name2.length - 1];
                return lastName1.compareTo(lastName2);
            }
        });

        for (Employee emp : sortedList) {
            System.out.println(emp);
        }
    }

    public static void sortEmployeeBySalary(CompanyManagement cm) {
        ArrayList<Employee> sortedList = cm.getEmpList();
        for (int i = 0; i < sortedList.size() - 1; i++) {
            for (int j = 1; j < sortedList.size(); j++) {
                if (sortedList.get(i).getSalary() > sortedList.get(j).getSalary()) {
                    Employee temp = sortedList.get(i);
                    sortedList.set(i, sortedList.get(j));
                    sortedList.set(j, temp);
                }
            }
        }
        for (Employee emp : sortedList) {
            System.out.println(emp);
        }
    }

    public static void printHeader(String header) {
        System.out.println("\n" + header);
        System.out.println("-----------------------------------");
    }

    public boolean checkTester(String info) {
        String[] subinfo = info.split(",");
        return subinfo[1].charAt(0) == 'T';
    }

    public boolean checkDeveloper(String info) {
        String[] subInfo = info.split(",");
        return subInfo[1].charAt(0) == 'D' && subInfo[5].charAt(0) != 'L';
    }

    public boolean checkTeamLeader(String info) {
        String[] subInfo = info.split(",");
        return subInfo[1].charAt(0) == 'D' && subInfo[5].charAt(0) == 'L';
    }

    public String languageTeamLeader(String info, List<String> language) {
        String[] subInfo = info.split(",");
        String s = new String();
        for (int i = 0; i < language.size(); i++) {
            String[] st = language.get(i).split(",");
            if (checkTeamLeader(info) && st[0].equals(subInfo[1])) {
                for (int j = 1; j < st.length; j++) {
                    s += st[j] + ",";
                }
            }
        }
        return s;
    }

    public String languageDeveloper(String info, List<String> language) {
        String[] subInfo = info.split(",");
        String s = new String();
        for (int i = 0; i < language.size(); i++) {
            String[] st = language.get(i).split(",");
            if (checkDeveloper(info) && st[0].equals(subInfo[1])) {
                for (int j = 1; j < st.length; j++) {
                    s += st[j] + ",";
                }
            }
        }
        return s;
    }

    public Employee getTester(String info) {
        String[] subinfo = info.split(",");
        return new Tester(subinfo[1], subinfo[2], Double.parseDouble(subinfo[3]), subinfo[4],
                Integer.parseInt(subinfo[5]));
    }

    public Employee getDeveloperAndTeamLeader(String info, List<String> language) {
        String[] subInfo = info.split(",");
        if (checkDeveloper(info)) {
            String[] lang = languageDeveloper(info, language).split(",");
            ArrayList<String> subLang = new ArrayList<>();
            for (int i = 0; i < lang.length; i++) {
                subLang.add(lang[i]);
            }
            return new Developer(subInfo[1], subLang, subInfo[2], subInfo[3], Integer.parseInt(subInfo[4]),
                    Integer.parseInt(subInfo[5]));
        }
        if (checkTeamLeader(info)) {
            String[] lang = languageTeamLeader(info, language).split(",");
            ArrayList<String> subLang = new ArrayList<>();
            for (int i = 0; i < lang.length; i++) {
                subLang.add(lang[i]);
            }
            return new TeamLeader(subInfo[1], subLang, subInfo[2], subInfo[3], Integer.parseInt(subInfo[4]),
                    Double.parseDouble(subInfo[6]), Integer.parseInt(subInfo[7]));
        }
        return null;
    }

    public ArrayList<Employee> sorted() throws Exception {
        ArrayList<Employee> sortedList = empList;
        for (int i = 0; i < sortedList.size() - 1; i++) {
            for (int j = 1; j < sortedList.size(); j++) {
                if (sortedList.get(i).getSalary() > sortedList.get(j).getSalary()) {
                    Employee temp = sortedList.get(i);
                    sortedList.set(i, sortedList.get(j));
                    sortedList.set(j, temp);
                }
            }
        }
        return sortedList;
    }

    public void printEmpList() {
        for (Employee emp : empList) {
            System.out.println(emp);
        }
    }

    public boolean writeFile(String path, ArrayList<Employee> employees) throws IOException {
        File file = new File(path);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Employee employee : employees) {
            bw.write(valid.formatEmployee(employee) + "\n");
        }

        bw.close();
        return true;
    }

    public ArrayList<Employee> getEmployeeFromFile(String filePath) throws IOException {
        ArrayList<Employee> employees = new ArrayList<>();
        File file = new File(filePath);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("_");
                String empID = parts[0];
                String empName = parts[1];
                double baseSal = Double.parseDouble(parts[2]);

                if (empID.startsWith("T")) {
                    double bonusRate = Double.parseDouble(parts[3]);
                    String type = parts[4];
                    employees.add(new Tester(empID, empName, baseSal, type, bonusRate));
                } else if (empID.startsWith("D")) {
                    String teamName = parts[3];
                    ArrayList<String> programmingLanguages = new ArrayList<>(Arrays.asList(parts[4]
                            .replace("[", "").replace("]", "").split(", ")));
                    int expYear = Integer.parseInt(parts[5]);

                    if (parts.length == 7) {
                        double bonusRate = Double.parseDouble(parts[6]);
                        employees.add(new TeamLeader(empID, programmingLanguages, empName, teamName, expYear, bonusRate,
                                baseSal));
                    } else {
                        employees.add(new Developer(empID, programmingLanguages, empName, teamName, expYear, baseSal));
                    }
                }
            }
        }
        return employees;
    }

}
