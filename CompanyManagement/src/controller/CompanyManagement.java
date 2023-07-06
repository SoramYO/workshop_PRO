package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Developer;
import model.TeamLeader;
import model.Tester;
import model.Employee;

public class CompanyManagement {

    private ArrayList<Employee> empList;

    public CompanyManagement(String path1, String path2) throws Exception {
        empList = getEmployeeFromFile(path1, path2);
    }

    public ArrayList<Employee> getEmployeeList() {
        return empList;
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
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < language.size(); i++) {
            String[] st = language.get(i).split(",");
            if (checkTeamLeader(info) && st[0].equals(subInfo[1])) {
                for (int j = 1; j < st.length; j++) {
                    sb.append(st[j]).append(",");
                }
            }
        }
        return sb.toString();
    }

    public String languageDeveloper(String info, List<String> language) {
        String[] subInfo = info.split(",");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < language.size(); i++) {
            String[] st = language.get(i).split(",");
            if (checkDeveloper(info) && st[0].equals(subInfo[1])) {
                for (int j = 1; j < st.length; j++) {
                    sb.append(st[j]).append(",");
                }
            }
        }
        return sb.toString();
    }

    public Employee getTester(String info) {
        String[] subinfo = info.split(",");
        return new Tester(subinfo[1], subinfo[2], Double.parseDouble(subinfo[3]), subinfo[4], Integer.parseInt(subinfo[5]));
    }

    public Employee getDeveloperAndTeamLeader(String info, List<String> language) {
        String[] subInfo = info.split(",");
        if (checkDeveloper(info)) {
            String[] lang = languageDeveloper(info, language).split(",");
            ArrayList<String> subLang = new ArrayList<>();
            for (int i = 0; i < lang.length; i++) {
                subLang.add(lang[i]);
            }
            return new Developer(subInfo[1], subInfo[2], Integer.parseInt(subInfo[5]), subInfo[3], subLang, Integer.parseInt(subInfo[4]));
        }
        if (checkTeamLeader(info)) {
            String[] lang = languageTeamLeader(info, language).split(",");
            ArrayList<String> subLang = new ArrayList<>();
            for (int i = 0; i < lang.length; i++) {
                subLang.add(lang[i]);
            }
            return new TeamLeader(subInfo[1], subInfo[2], Integer.parseInt(subInfo[7]), subInfo[3], subLang, Integer.parseInt(subInfo[4]), Double.parseDouble(subInfo[6]));
        }
        return null;
    }

    public ArrayList<Employee> getEmployeeFromFile(String path1, String path2) throws Exception {
        File file1 = new File(path1);
        File file2 = new File(path2);
        List<String> allEmployee = Files.readAllLines(file1.toPath());
        List<String> allLanguage = Files.readAllLines(file2.toPath());
        ArrayList<Employee> list = new ArrayList<>();
        for (int i = 0; i < allEmployee.size(); i++) {
            if (checkTester(allEmployee.get(i))) {
                list.add(getTester(allEmployee.get(i)));
            } else {
                list.add(getDeveloperAndTeamLeader(allEmployee.get(i), allLanguage));
            }
        }
        return list;
    }

    public ArrayList<Employee> getDeveloperByProgrammingLanguage(String pl) {
        ArrayList<Employee> devList = new ArrayList<>();
        for (Employee emp : empList) {
            if (emp instanceof Developer) {
                Developer developer = (Developer) emp;
                if (developer.getProgrammingLanguages().contains(pl)) {
                    devList.add(developer);
                }
            }
        }
        return devList;
    }

    public ArrayList<Tester> getTestersHaveSalaryGreaterThan(double value) {
        ArrayList<Tester> testerList = new ArrayList<>();
        for (Employee emp : empList) {
            if (emp instanceof Tester) {
                Tester tester = (Tester) emp;
                if (tester.getSalary() > value) {
                    testerList.add(tester);
                }
            }
        }
        return testerList;
    }

    public Employee getEmployeeWithHighestSalary() throws Exception {
        if (empList.isEmpty()) {
            return null;
        }

        Employee highestEmp = empList.get(0);

        for (Employee employee : empList) {
            if (employee.getSalary() > highestEmp.getSalary()) {
                highestEmp = employee;
            }
        }

        return highestEmp;
    }

    public TeamLeader getLeaderWithMostEmployees() {
        Map<String, Integer> teamCount = new HashMap<>();
        for (Employee emp : empList) {
            if (emp instanceof Developer) {
                Developer developer = (Developer) emp;
                String teamName = developer.getTeamName();
                teamCount.put(teamName, teamCount.getOrDefault(teamName, 0) + 1);
            }
        }
        int maxCount = 0;
        String teamWithMostEmployees = null;
        for (Map.Entry<String, Integer> entry : teamCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                teamWithMostEmployees = entry.getKey();
            }
        }
        if (teamWithMostEmployees != null) {
            for (Employee emp : empList) {
                if (emp instanceof TeamLeader) {
                    TeamLeader leader = (TeamLeader) emp;
                    if (leader.getTeamName().equals(teamWithMostEmployees)) {
                        return leader;
                    }
                }
            }
        }
        return null;
    }

    // Sort Employees as descending salary
    public ArrayList<Employee> sorted() throws Exception {
        ArrayList<Employee> sortedList = new ArrayList<>(empList);

        // Implement a custom Comparator to compare employees based on their salary
        Comparator<Employee> salaryComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                return Double.compare(emp2.getSalary(), emp1.getSalary());
            }
        };

        // Sort the sortedList using the salaryComparator
        Collections.sort(sortedList, salaryComparator);

        return sortedList;
    }

    public boolean writeEmployeeListToFile(String path, List<? extends Employee> employees) {
    List<String> employeeLines = new ArrayList<>();
    for (Employee emp : employees) {
        employeeLines.add(emp.toString());
    }
    try {
        Files.write(new File(path).toPath(), employeeLines);
        return true;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}


}
