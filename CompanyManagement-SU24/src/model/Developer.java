package model;

import java.util.ArrayList;

public class Developer extends Employee {

    protected String teamName;
    protected ArrayList<String> programmingLanguages;
    protected int expYear;

    public Developer(String empID, ArrayList<String> programmingLanguages, String empName, String teamName, int expYear,
            double baseSal) {
        super(empID, empName, baseSal);
        this.teamName = teamName;
        this.programmingLanguages = programmingLanguages;
        this.expYear = expYear;
    }

    public String getTeamName() {
        return teamName;
    }

    public ArrayList<String> getProgrammingLanguages() {
        return programmingLanguages;
    }

    public int getExpYear() {
        return expYear;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setProgrammingLanguages(ArrayList<String> programmingLanguages) {
        this.programmingLanguages = programmingLanguages;
    }

    public void setExpYear(int expYear) {
        this.expYear = expYear;
    }

    @Override
    public String toString() {
        return super.toString() + "_" + teamName + "_" + programmingLanguages.toString() + "_" + expYear;
    }

    @Override
    public double getSalary() {
        if (expYear >= 5)
            return baseSal + expYear * 2000000;
        else if (expYear >= 3 && expYear < 5)
            return baseSal + expYear * 1000000;
        else
            return baseSal;
    }
}
