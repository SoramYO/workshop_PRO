package controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import model.Developer;
import model.TeamLeader;
import model.Tester;
import model.Employee;

public class CompanyManagement {

    private ArrayList<Employee> empList;

    // Contructor and read file
    public CompanyManagement(String path1, String path2) throws Exception {
        empList = getEmployeeFromFile(path1, path2);
    }

    // reads from the file into the empList
    public ArrayList<Employee> getEmployeeFromFile(String path1, String path2) throws Exception {
        ArrayList<Employee> list = null;
        try {
            File fPLInfo = new File(path2);
            String fullPath = fPLInfo.getAbsolutePath();
            FileInputStream filePLInfo = new FileInputStream(fullPath);
            BufferedReader myInputPLInfo;
            myInputPLInfo = new BufferedReader(new InputStreamReader(filePLInfo));
            HashMap<String, ArrayList<String>> hashPLInfo = null;
            String thisLinePLInfo;
            while ((thisLinePLInfo = myInputPLInfo.readLine()) != null) {
                if (!thisLinePLInfo.trim().isEmpty()) {
                    String[] split = thisLinePLInfo.split(",");
                    if (hashPLInfo == null) {
                        hashPLInfo = new HashMap<>();
                    }
                    String key = split[0].trim();
                    ArrayList<String> plinfo = new ArrayList<>();
                    for (int i = 1; i < split.length; i++) {
                        plinfo.add(split[i].trim());
                    }
                    hashPLInfo.put(key, plinfo);
                }
            }
            myInputPLInfo.close();
            // READ EMPLOYEE
            String thisLine;
            BufferedReader myInputEmp;
            File fEmp = new File(path1);
            //System.out.println(path1);
            fullPath = fEmp.getAbsolutePath();
            FileInputStream fileEmp = new FileInputStream(fullPath);
            myInputEmp = new BufferedReader(new InputStreamReader(fileEmp));
            while ((thisLine = myInputEmp.readLine()) != null) {
                Employee emp = null;
                if (!thisLine.trim().isEmpty()) {
                    String[] split = thisLine.split(",");
                    if (split.length == 5) {
                        String id = split[1].trim();
                        String name = split[2].trim();
                        String team = split[3].trim();
                        int expY = Integer.parseInt(split[4].trim());
                        int balS = Integer.parseInt(split[5].trim());
                        ArrayList<String> progL = hashPLInfo.get(id);
                        emp = new Developer(id, name, balS, team, progL, expY);
                        System.out.println(toString());
                    } else if (split.length == 8) {
                        String id = split[1].trim();
                        String name = split[2].trim();
                        String team = split[3].trim();
                        int expY = Integer.parseInt(split[4].trim());
                        int balS = Integer.parseInt(split[5].trim());
                        double bonus = Double.parseDouble(split[6].trim());
                        ArrayList<String> progL = hashPLInfo.get(id);
                        emp = new TeamLeader(id, name, balS, team, progL, expY, bonus);
                        System.out.println(emp.toString());
                    } else if (split[1].trim().charAt(0) == 'T') {
                        String id = split[1].trim();
                        String name = split[2].trim();
                        double bonus = Integer.parseInt(split[3].trim());
                        String type = split[4].trim();
                        int balS = Integer.parseInt(split[5].trim());
                        ArrayList<String> progL = hashPLInfo.get(id);
                        emp = new Tester(id, name, balS, bonus, type);
                        System.out.println(emp.toString());
                    }
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(emp);
                }
            }
            myInputEmp.close();
        } catch (Exception ex) {
            throw ex;
        }
        return list;
    }

    // list of programmers who are proficient in the input pl programmingLanguage.
    public ArrayList<Employee> getDeveloperByProgrammingLanguage(String pl) {
        ArrayList<Employee> devList = null;
        return devList;
    }

    // list of testers whose total salary is greater than the value of the parameter
    public ArrayList<Tester> getTestersHaveSalaryGreaterThan(double value) throws Exception {
        ArrayList<Tester> testerList = null;

        return testerList;
    }

    public Employee getEmployeeWithHighestSalary() throws Exception {
        Employee highestEmp = null;

        return highestEmp;
    }

    // get the team leader of the group with the most programmers
    public TeamLeader getLeaderWithMostEmployees() throws Exception {
        TeamLeader leader = null;

        return leader;
    }

    // Sort Employees as descending salary
    public ArrayList<Employee> sorted() throws Exception {
        ArrayList<Employee> sortedList = null;

        return sortedList;
    }

    // print empList
    public void printEmpList() {
        for (Employee emp : empList) {
            System.out.println(emp);
        }
    }

    // write emplist
    public <E> boolean writeFile(String path, ArrayList<E> list) throws Exception {
        return true;
    }
}
