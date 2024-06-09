package model;

import java.util.ArrayList;

public class TeamLeader extends Developer {

    private double bonus_rate;

    public TeamLeader(String empID, ArrayList<String> programmingLanguages, String empName, String teamName,
            int expYear, double bonus_rate, double baseSal) {
        super(empID, programmingLanguages, empName, teamName, expYear, baseSal);
        this.bonus_rate = bonus_rate;
    }

    public double getBonus_rate() {
        return bonus_rate;
    }

    public void setBonus_rate(double bonus_rate) {
        this.bonus_rate = bonus_rate;
    }

    public double getSalaryTL() {
        return getSalary() + getSalary() * bonus_rate;
    }

    public String toString() {
        return super.toString() + "_" + bonus_rate;
    }

}
