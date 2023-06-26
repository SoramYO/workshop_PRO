package controller;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
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



    // reads from the file into the empList
    public ArrayList<Employee> getEmployeeFromFile(String path1, String path2) throws Exception {
        File file1 = new File(path1);
        File file2 = new File(path2);
        List<String> allEmployee = Files.readAllLines(file1.toPath());
        List<String> allLanguage = Files.readAllLines(file2.toPath());
        ArrayList<Employee> list = new ArrayList<>();
        for (int i = 0; i < allEmployee.size(); i++) {
            if(checkTester(allEmployee.get(i))) list.add(getTester(allEmployee.get(i)));
            else list.add(getDeveloperAndTeamLeader(allEmployee.get(i), allLanguage));
        }
        return list;
    }

    // list of programmers who are proficient in the input pl programmingLanguage.
    public ArrayList<Employee> getDeveloperByProgrammingLanguage(String pl) {
        ArrayList<Employee> devList = new ArrayList<>();
        for (int i = 0; i < empList.size(); i++) {
            if (empList.get(i) instanceof Developer) {
                ArrayList<String> language = ((Developer)empList.get(i)).getProgrammingLanguages();
                for (int j = 0; j < language.size(); j++) {
                    if(language.get(j).equalsIgnoreCase(pl.trim())) devList.add(empList.get(i));
                }
            }
        }
        return devList;
    }

    // list of testers whose total salary is greater than the value of the parameter
    public ArrayList<Tester> getTestersHaveSalaryGreaterThan(double value) throws Exception {
        ArrayList<Tester> testerList = new ArrayList<>();
        for (int i = 0; i < empList.size(); i++) {
            if(empList.get(i) instanceof Tester && ((Tester)empList.get(i)).getSalary() > value)
                testerList.add((Tester) empList.get(i));
        }
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
